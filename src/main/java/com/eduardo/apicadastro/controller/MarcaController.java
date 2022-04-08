package com.eduardo.apicadastro.controller;

import com.eduardo.apicadastro.dto.Marca;
import com.eduardo.apicadastro.dto.ResponseSucesso;
import com.eduardo.apicadastro.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("marca")
public class MarcaController {
    @Autowired
    MarcaService marcaService;

    @PostMapping
    public ResponseEntity<ResponseSucesso> incluirMarca(@RequestBody Marca marca){
        ResponseSucesso responseSucesso = marcaService.incluirMarca(marca);
        if(responseSucesso.getId()==null)
            return ResponseEntity.badRequest().body(responseSucesso);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseSucesso);
    }

    @GetMapping("lista")
    public ResponseEntity<List<Marca>> listaMarca(){
        List<Marca> listaMarca = marcaService.listaMarca();
        if(listaMarca.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(listaMarca);
    }

    @GetMapping("{id}")
    public ResponseEntity<Marca> buscaMarca(@PathVariable Integer id){
        Marca marca = marcaService.buscaMarca(id);
        if(marca==null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(marca);
    }
}
