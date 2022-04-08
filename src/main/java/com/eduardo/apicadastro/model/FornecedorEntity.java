package com.eduardo.apicadastro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbFornecedor")
@Getter
@Setter
@AllArgsConstructor
public class FornecedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nome;

    private String cpf;

    private String cnpj;

    public FornecedorEntity(){}
}