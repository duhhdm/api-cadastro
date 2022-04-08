package com.eduardo.apicadastro.dto;

import com.eduardo.apicadastro.model.FornecedorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
public class Fornecedor {

    private Integer id;
    private String nome;

    @CPF
    private String cpf;

    @CNPJ
    private String cnpj;

    public Fornecedor(){

    }

    public FornecedorEntity converterFornecedor(Fornecedor fornecedor) {
        return new FornecedorEntity(fornecedor.getId(),fornecedor.getNome(), fornecedor.getCpf(), fornecedor.getCnpj());
    }
}
