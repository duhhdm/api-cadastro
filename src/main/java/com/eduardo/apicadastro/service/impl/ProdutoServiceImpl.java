package com.eduardo.apicadastro.service.impl;

import com.eduardo.apicadastro.dto.Produto;
import com.eduardo.apicadastro.dto.ResponseSucesso;
import com.eduardo.apicadastro.model.CategoriaEntity;
import com.eduardo.apicadastro.model.MarcaEntity;
import com.eduardo.apicadastro.model.ProdutoEntity;
import com.eduardo.apicadastro.repository.CategoriaRepository;
import com.eduardo.apicadastro.repository.MarcaRepository;
import com.eduardo.apicadastro.repository.ProdutoRepository;
;
import com.eduardo.apicadastro.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public ResponseSucesso incluirProduto(Produto produto) {
        Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(produto.getCategoria());
        Optional<MarcaEntity> marcaEntity = marcaRepository.findById(produto.getMarca());
        if(categoriaEntity.isPresent() || marcaEntity.isPresent())
            return new ResponseSucesso(null, "Não foi possivel cadastrar o produto");
        ProdutoEntity persistence = new Produto().converterProduto(produto,categoriaEntity.get(),marcaEntity.get());
        produtoRepository.save(persistence);
        return new ResponseSucesso(persistence.getIdProduto().toString(),"Produto "+ persistence.getNomeProduto() + "Cadastrado com sucesso");
    }

    @Override
    public List<Produto> listarProdutos() {
        return new Produto().converterLista(produtoRepository.findAll());
    }

    @Override
    public Produto buscaProduto(Integer id) {
        Optional<ProdutoEntity> produto = produtoRepository.findById(id);
        return produto.map(produtoEntity -> new Produto().converteProdutoEntity(produtoEntity)).orElse(null);
    }

}
