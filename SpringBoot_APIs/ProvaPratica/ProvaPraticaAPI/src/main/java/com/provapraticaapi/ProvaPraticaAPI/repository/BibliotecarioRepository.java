package com.provapraticaapi.ProvaPraticaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.provapraticaapi.ProvaPraticaAPI.model.BibliotecarioModel;

@Repository
public interface BibliotecarioRepository extends JpaRepository<BibliotecarioModel, Long> {
    
}
