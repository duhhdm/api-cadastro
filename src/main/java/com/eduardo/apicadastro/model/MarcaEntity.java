package com.eduardo.apicadastro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbMarca")
@Getter
@Setter
@AllArgsConstructor
public class MarcaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMarca", nullable = false)
    private Integer idMarca;

    @Column(name= "nomeMarca", nullable = false)
    private String nomeMarca;

    private Boolean ativo;

    @ManyToOne
    private CategoriaEntity categoriaId;




    public MarcaEntity() {}
}