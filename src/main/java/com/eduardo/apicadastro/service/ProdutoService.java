package com.eduardo.apicadastro.service;

import com.eduardo.apicadastro.dto.Produto;
import com.eduardo.apicadastro.dto.ResponseSucesso;

import java.util.List;

public interface ProdutoService {
    ResponseSucesso incluirProduto(Produto produto);

    List<Produto> listarProdutos();

    Produto buscaProduto(Integer id);
}
