package com.eduardo.apicadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseSucesso {

    private String id;
    private String mensagem;

    public ResponseSucesso() {

    }
}
