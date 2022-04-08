package com.eduardo.apicadastro.service.impl;

import com.eduardo.apicadastro.dto.Categoria;
import com.eduardo.apicadastro.dto.ResponseSucesso;
import com.eduardo.apicadastro.model.CategoriaEntity;
import com.eduardo.apicadastro.repository.CategoriaRepository;
import com.eduardo.apicadastro.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public ResponseSucesso incluirCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity(null, categoria.getNome().toUpperCase(), true);
        if(categoriaRepository.findByNome(categoria.getNome()).isPresent())
            return new ResponseSucesso(null,"Categoria ja cadastrada");;
        categoriaRepository.save(categoriaEntity);
        return new ResponseSucesso(categoriaEntity.getIdCategoria().toString(),"Categoria "+ categoriaEntity.getNome() +" cadastrada com sucesso");
    }

    @Override
    public List<Categoria> listarCategorias() {
        return new Categoria().converterLista(categoriaRepository.findAll());
    }

    @Override
    public Optional<CategoriaEntity> buscaCategoria(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public ResponseSucesso inativarCategoria(Integer id) {
        Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(id);
        if(!categoriaEntity.isPresent()){
            return new ResponseSucesso(null, "Categoria não encontrada");
        }
        categoriaEntity.get().setAtivo(false);
        categoriaRepository.save(categoriaEntity.get());
        return new ResponseSucesso(categoriaEntity.get().getIdCategoria().toString()
                , "Categoria "+ categoriaEntity.get().getNome() +" Inativada");
    }

}
