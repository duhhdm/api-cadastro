package com.eduardo.apicadastro.model.key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class FornecedorMarcaKey implements Serializable {

    @Column(name="fornecedorId")
    private Integer fornecedorId;

    @Column(name="marcaId")
    private Integer marcaId;

    public FornecedorMarcaKey() {

    }
}