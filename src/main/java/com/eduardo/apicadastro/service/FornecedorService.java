package com.eduardo.apicadastro.service;

import com.eduardo.apicadastro.dto.Fornecedor;
import com.eduardo.apicadastro.dto.ResponseSucesso;

public interface FornecedorService {
    ResponseSucesso incluirFornecedor(Fornecedor fornecedor);
}
