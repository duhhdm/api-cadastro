package com.eduardo.apicadastro.repository;

import com.eduardo.apicadastro.model.FornecedorMarcaEntity;
import com.eduardo.apicadastro.model.key.FornecedorMarcaKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorMarcaRepository extends JpaRepository<FornecedorMarcaEntity, FornecedorMarcaKey> {

}