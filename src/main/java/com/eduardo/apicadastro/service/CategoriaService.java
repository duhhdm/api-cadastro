package com.eduardo.apicadastro.service;

import com.eduardo.apicadastro.dto.Categoria;
import com.eduardo.apicadastro.dto.ResponseSucesso;
import com.eduardo.apicadastro.model.CategoriaEntity;

import java.util.List;
import java.util.Optional;


public interface CategoriaService {
    ResponseSucesso incluirCategoria(Categoria categoria);

    List<Categoria> listarCategorias();

    Optional<CategoriaEntity> buscaCategoria(Integer id);

    ResponseSucesso inativarCategoria(Integer id);
}
