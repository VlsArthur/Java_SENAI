package com.bancoimagens.BancoImagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancoimagens.BancoImagens.model.ImagemModel;
import com.bancoimagens.BancoImagens.service.ImagemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin("*")
@RequestMapping("api/imagens")
public class ImagemController {
    @Autowired
    private ImagemService imagemService;

    @PostMapping
    public ImagemModel save(@RequestBody ImagemModel imagemModel) {
        return imagemService.save(imagemModel);
    }

    @GetMapping
    public List<ImagemModel> listAll() {
        return imagemService.listAll();
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (imagemService.findByID(id).isPresent()) {
            imagemService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagemModel> update(@PathVariable Long id, @RequestBody ImagemModel imagemModel) {
        if (imagemService.findByID(id).isPresent()) {
            imagemModel.setId(id);
            return ResponseEntity.ok(imagemService.save(imagemModel));
        }
        return ResponseEntity.notFound().build();
    }
}
