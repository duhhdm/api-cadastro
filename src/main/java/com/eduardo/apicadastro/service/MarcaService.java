package com.eduardo.apicadastro.service;

import com.eduardo.apicadastro.dto.Marca;
import com.eduardo.apicadastro.dto.ResponseSucesso;

import java.util.List;

public interface MarcaService {
    public ResponseSucesso incluirMarca(Marca marca);

    List<Marca> listaMarca();

    Marca buscaMarca(Integer id);
}
