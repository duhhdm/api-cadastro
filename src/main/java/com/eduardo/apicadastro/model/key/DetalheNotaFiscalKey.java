package com.eduardo.apicadastro.model.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DetalheNotaFiscalKey implements Serializable {

    @Column(name="notaFiscalId")
     private Integer notaFiscalId;

    @Column(name="produtoId")
    private Integer produtoId;

}