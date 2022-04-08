package com.eduardo.apicadastro.repository;

import com.eduardo.apicadastro.model.MarcaEntity;
import com.eduardo.apicadastro.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {

    Optional<ProdutoEntity> findByNomeProdutoAndMarca(String produto, MarcaEntity marca);
}
