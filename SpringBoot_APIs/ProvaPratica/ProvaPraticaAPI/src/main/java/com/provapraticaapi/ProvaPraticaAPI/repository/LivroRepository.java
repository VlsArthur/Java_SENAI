package com.provapraticaapi.ProvaPraticaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.provapraticaapi.ProvaPraticaAPI.model.LivroModel;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {
    
}
