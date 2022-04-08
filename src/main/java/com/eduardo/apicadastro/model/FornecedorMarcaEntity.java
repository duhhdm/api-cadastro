package com.eduardo.apicadastro.model;

import com.eduardo.apicadastro.model.key.FornecedorMarcaKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbFornecedorMarca")
@Getter
@Setter
@AllArgsConstructor
public class FornecedorMarcaEntity {

    @EmbeddedId
    private FornecedorMarcaKey id;

    @ManyToOne
    @MapsId("marcaId")
    @JoinColumn(name= "marcaId")
    private MarcaEntity marcaId;

    @ManyToOne
    @MapsId("fornecedorId")
    @JoinColumn(name= "fornecedorId")
    private FornecedorEntity fornecedorId;

    private Boolean ativo;

    public FornecedorMarcaEntity() {

    }
}