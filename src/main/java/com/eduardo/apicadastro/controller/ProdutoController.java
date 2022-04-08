package com.eduardo.apicadastro.controller;

import com.eduardo.apicadastro.dto.Produto;
import com.eduardo.apicadastro.dto.ResponseSucesso;
import com.eduardo.apicadastro.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ResponseSucesso> incluirProduto(@RequestBody Produto produto){
        ResponseSucesso responseSucesso = produtoService.incluirProduto(produto);
        if(responseSucesso.getId()==null)
            return ResponseEntity.badRequest().body(responseSucesso);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseSucesso);
    }

    @GetMapping("lista")
    public ResponseEntity<List<Produto>> listarProduto(){
        List<Produto> produtos = produtoService.listarProdutos();
        if(!produtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);

    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Integer id){
        Produto produto = produtoService.buscaProduto(id);
        if(produto==null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(produto);
    }
}
