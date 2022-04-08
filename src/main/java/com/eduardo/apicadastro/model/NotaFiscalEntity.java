package com.eduardo.apicadastro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbNotaFiscal")
@Getter
@Setter
@AllArgsConstructor
public class NotaFiscalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idNotaFiscal", nullable = false)
    private Integer idNotaFiscal;

    private Integer nrDocto;

    private Long vlTotal;

    @ManyToOne
    private FornecedorEntity fornecedor;

    public NotaFiscalEntity() {

    }
}