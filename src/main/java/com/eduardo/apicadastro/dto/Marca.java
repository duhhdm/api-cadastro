package com.eduardo.apicadastro.dto;

import com.eduardo.apicadastro.model.CategoriaEntity;
import com.eduardo.apicadastro.model.MarcaEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Marca implements Serializable {

    private Integer idMarca;
    private String nomeMarca;
    private Boolean ativo;
    private Integer idCategoria;
    private Integer idFornecedor;

    public Marca(){

    }

    public MarcaEntity converteMarca(Marca marca, CategoriaEntity categoriaEntity) {
        return new MarcaEntity(marca.getIdMarca(),marca.getNomeMarca(),marca.getAtivo(),categoriaEntity);
    }

    public Marca converteMarcaEntity(MarcaEntity marcaEntity){
        Marca marca = new Marca();
        marca.setIdMarca(marcaEntity.getIdMarca());
        marca.setNomeMarca(marcaEntity.getNomeMarca());
        marca.setIdCategoria(marcaEntity.getCategoriaId().getIdCategoria());
        marca.setAtivo(marcaEntity.getAtivo());
        return marca;
    }

    public List<Marca> converteListaMarca(List<MarcaEntity> marcas) {
        List<Marca> marcaList = new ArrayList<>();

        for (MarcaEntity marca : marcas) {
            marcaList.add(converteMarcaEntity(marca));
        }

        return marcaList;
    }
}
