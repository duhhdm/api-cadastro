package com.eduardo.apicadastro.dto;

import com.eduardo.apicadastro.model.CategoriaEntity;
import com.eduardo.apicadastro.model.MarcaEntity;
import com.eduardo.apicadastro.model.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Produto {
    Integer id;
    String nome;
    Integer categoria;
    Integer marca;

    public Produto() {

    }



    public ProdutoEntity converterProduto(Produto produto, CategoriaEntity categoria, MarcaEntity marcaEntity){
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setIdProduto(produto.getId());
        produtoEntity.setNomeProduto(produto.getNome().toUpperCase());
        produtoEntity.setCategoria(categoria);
        produtoEntity.setMarca(marcaEntity);
        return produtoEntity;
    }

    public Produto converteProdutoEntity(ProdutoEntity produtoEntity){

        return new Produto(produtoEntity.getIdProduto(),
                produtoEntity.getNomeProduto(),
                produtoEntity.getCategoria().getIdCategoria(),
                produtoEntity.getMarca().getIdMarca());
    }

    public List<Produto> converterLista(List<ProdutoEntity> produtos) {
        List<Produto> listaProduto = new ArrayList<>();
        for (ProdutoEntity produto : produtos ) {
            listaProduto.add(new Produto().converteProdutoEntity(produto));
        }
        return listaProduto;
    }
}
