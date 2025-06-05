package com.bancoimagens.BancoImagens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoimagens.BancoImagens.model.ImagemModel;
import com.bancoimagens.BancoImagens.repository.ImagemRepository;

@Service
public class ImagemService {
    @Autowired
    private ImagemRepository imagemRepository;

    public List<ImagemModel> listAll() {
        return imagemRepository.findAll();
    }

    public ImagemModel save(ImagemModel imagemModel) {
        return imagemRepository.save(imagemModel);
    }

    public void delete(Long id) {
        imagemRepository.deleteById(id);
    }

    public Optional<ImagemModel> findByID(Long id) {
        return imagemRepository.findById(id);
    }
}
