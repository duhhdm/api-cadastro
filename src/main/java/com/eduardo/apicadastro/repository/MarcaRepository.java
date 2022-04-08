package com.eduardo.apicadastro.repository;

import com.eduardo.apicadastro.model.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaRepository extends JpaRepository<MarcaEntity, Integer> {
    public Optional<MarcaEntity> findByNomeMarca(String nomeMarca);
}