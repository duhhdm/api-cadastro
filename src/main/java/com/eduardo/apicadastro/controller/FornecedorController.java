package com.eduardo.apicadastro.controller;

import com.eduardo.apicadastro.dto.Fornecedor;
import com.eduardo.apicadastro.dto.ResponseSucesso;
import com.eduardo.apicadastro.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<ResponseSucesso> cadastrarFornecedor(@Valid @RequestBody Fornecedor fornecedor){
        ResponseSucesso responseSucesso = fornecedorService.incluirFornecedor(fornecedor);
        if(responseSucesso.getId()==null)
            return ResponseEntity.badRequest().body(responseSucesso);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseSucesso);
    }

}
