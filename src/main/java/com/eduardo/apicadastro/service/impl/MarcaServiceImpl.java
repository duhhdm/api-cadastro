package com.eduardo.apicadastro.service.impl;

import com.eduardo.apicadastro.dto.Marca;
import com.eduardo.apicadastro.dto.ResponseSucesso;
import com.eduardo.apicadastro.model.CategoriaEntity;
import com.eduardo.apicadastro.model.FornecedorEntity;
import com.eduardo.apicadastro.model.FornecedorMarcaEntity;
import com.eduardo.apicadastro.model.MarcaEntity;
import com.eduardo.apicadastro.model.key.FornecedorMarcaKey;
import com.eduardo.apicadastro.repository.CategoriaRepository;
import com.eduardo.apicadastro.repository.FornecedorMarcaRepository;
import com.eduardo.apicadastro.repository.FornecedorRepository;
import com.eduardo.apicadastro.repository.MarcaRepository;
import com.eduardo.apicadastro.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    FornecedorMarcaRepository fornecedorMarcaRepository;

    @Override
    public ResponseSucesso incluirMarca(Marca marca) {
        Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(marca.getIdCategoria());

        if(!categoriaEntity.isPresent())
            return new ResponseSucesso(null,"Categoria não cadastrada");

        MarcaEntity marcaEntity = marca.converteMarca(marca,categoriaEntity.get());
        Optional<FornecedorEntity> fornecedorEntity = fornecedorRepository.findById(marca.getIdFornecedor());
        FornecedorMarcaEntity fornecedorMarcaEntity = new FornecedorMarcaEntity();
        if(marcaRepository.findByNomeMarca(marcaEntity.getNomeMarca()).isPresent()){
            return new ResponseSucesso(null,"Marca ja Cadastrada");
        }
        if(!fornecedorEntity.isPresent())
            return new ResponseSucesso(null, "Fornecedor não encontrado");
        fornecedorMarcaEntity.setMarcaId(marcaEntity);
        fornecedorMarcaEntity.setFornecedorId(fornecedorEntity.get());
        marcaEntity.setAtivo(true);
        fornecedorMarcaEntity.setAtivo(true);
        fornecedorMarcaEntity.setId(new FornecedorMarcaKey(fornecedorEntity.get().getId(),marcaEntity.getIdMarca()));
        marcaRepository.save(marcaEntity);
        fornecedorMarcaRepository.save(fornecedorMarcaEntity);

        return new ResponseSucesso(marcaEntity.getIdMarca().toString(), "Marca "
                + marcaEntity.getNomeMarca() + " Cadastrada com sucesso");
    }

    @Override
    public List<Marca> listaMarca() {
        return new Marca().converteListaMarca(marcaRepository.findAll());
    }

    @Override
    public Marca buscaMarca(Integer id) {
        Optional<MarcaEntity> marcaEntity = marcaRepository.findById(id);
        return marcaEntity.map(entity -> new Marca().converteMarcaEntity(entity)).orElse(null);
    }


}
