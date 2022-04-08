package com.eduardo.apicadastro.model;

import com.eduardo.apicadastro.model.key.DetalheNotaFiscalKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbDetalheNotaFiscal")
@Getter
@Setter
@AllArgsConstructor
public class DetalheNotaFiscalEntity {

    @EmbeddedId
    private DetalheNotaFiscalKey id;

    @ManyToOne
    @MapsId("notaFiscalId")
    @JoinColumn(name="notaFiscalId")
    private NotaFiscalEntity notaFiscalId;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name="produtoId")
    private ProdutoEntity produtoId;

    private Integer quantidade;

    private Long valorUnitario;

    private Boolean baixa;

    public DetalheNotaFiscalEntity(){

    }
}