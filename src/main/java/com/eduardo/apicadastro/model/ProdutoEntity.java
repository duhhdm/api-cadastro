package com.eduardo.apicadastro.model;

import com.eduardo.apicadastro.dto.Categoria;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tbProduto")
@Getter
@Setter
@AllArgsConstructor
public class ProdutoEntity {

    @Id
    @Column(name="idProduto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduto;

    @Column(name="nomeProduto")
    private String nomeProduto;

    @ManyToOne
    private CategoriaEntity categoria;

    @ManyToOne
    private MarcaEntity marca;

    private Boolean ativo;

    private Long vlVenda;


    public ProdutoEntity() {

    }
}
