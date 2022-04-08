package com.eduardo.apicadastro.dto;

import com.eduardo.apicadastro.model.CategoriaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Categoria {
    private Integer id;
    private String nome;
    private Boolean ativo;

    public Categoria(){}

    public Categoria converterCategoria(CategoriaEntity categoriaEntity){
        Categoria categoria = new Categoria();
        categoria.setId(categoriaEntity.getIdCategoria());
        categoria.setNome(categoriaEntity.getNome().toUpperCase());
        categoria.setAtivo(categoriaEntity.getAtivo());
        return categoria;
    }

    public List<Categoria> converterLista(List<CategoriaEntity> categorias){
        List<Categoria> retorno = new ArrayList<>();
        for (CategoriaEntity categoriaEntity: categorias) {
            retorno.add(converterCategoria(categoriaEntity));
        }
        return retorno;
    }
}
