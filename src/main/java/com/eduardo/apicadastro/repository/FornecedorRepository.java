package com.eduardo.apicadastro.repository;

import com.eduardo.apicadastro.model.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Integer> {
    Optional<FornecedorEntity> findByCpf(String cpf);

    Optional<FornecedorEntity> findByCnpj(String cnpj);
}