package com.consumoapi.ConsumoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumoapi.ConsumoAPI.model.CargoModel;

@Repository
public interface CargoRepository extends JpaRepository<CargoModel, Long> {
    
}
