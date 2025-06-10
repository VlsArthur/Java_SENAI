package com.consumoapi.ConsumoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumoapi.ConsumoAPI.model.FuncionarioCargoModel;

@Repository
public interface FuncionarioCargoRepository extends JpaRepository<FuncionarioCargoModel, Long> {
    
}
