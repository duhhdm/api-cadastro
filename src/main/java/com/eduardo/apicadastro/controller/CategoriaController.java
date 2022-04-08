package com.eduardo.apicadastro.controller;

import com.eduardo.apicadastro.dto.Categoria;
import com.eduardo.apicadastro.dto.ResponseSucesso;
import com.eduardo.apicadastro.model.CategoriaEntity;

import com.eduardo.apicadastro.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("test")
    public String test(){
        return "ola mundo";
    }

    @PostMapping
    public ResponseEntity<ResponseSucesso> cadastrarCategoria(@RequestBody Categoria categoria){
        ResponseSucesso responseSucesso = categoriaService.incluirCategoria(categoria);
        if(responseSucesso.getId()==null){
            return ResponseEntity.badRequest().body(responseSucesso);
        }
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(responseSucesso);
    }

    @GetMapping("lista")
    public ResponseEntity<List<Categoria>> listaCategoria(){
        List<Categoria> categorias = categoriaService.listarCategorias();
        if(categorias.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> buscaCategoria(@PathVariable Integer id){
        Optional<CategoriaEntity> categoria = categoriaService.buscaCategoria(id);
        return categoria.map(categoriaEntity -> ResponseEntity.
                ok(new Categoria()
                        .converterCategoria(categoriaEntity)))
                .orElseGet(()
                        -> ResponseEntity.noContent().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseSucesso> inativaCategoria(@PathVariable Integer id){
        ResponseSucesso responseSucesso = categoriaService.inativarCategoria(id);
        if(responseSucesso==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(responseSucesso);
    }
}
