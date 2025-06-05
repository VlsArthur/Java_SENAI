package com.bancoimagens.BancoImagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancoimagens.BancoImagens.model.ImagemModel;

@Repository
public interface ImagemRepository extends JpaRepository<ImagemModel, Long> {
    
}
