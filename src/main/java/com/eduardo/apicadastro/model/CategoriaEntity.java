package com.eduardo.apicadastro.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tbCategoria")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategoria")
    private Integer idCategoria;

    @Column(name="nomeCategoria")
    private String nome;

    @Column(name="ativo")
    private Boolean ativo;

    public CategoriaEntity() {

    }
}
