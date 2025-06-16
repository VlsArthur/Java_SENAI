package com.provapraticaapi.ProvaPraticaAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.provapraticaapi.ProvaPraticaAPI.model.LivroModel;
import com.provapraticaapi.ProvaPraticaAPI.service.LivroService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroModel> listarTodos() {
        return livroService.listarTodos();
    }

    @PostMapping
    public LivroModel salvar(@RequestBody LivroModel livroModel) {
        return livroService.salvar(livroModel);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (livroService.buscarPorId(id).isPresent()) {
            livroService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<LivroModel> atualizar(@PathVariable Long id, @RequestBody LivroModel livroModel) {
        if (livroService.buscarPorId(id).isPresent()) {
            livroModel.setId(id);
            return ResponseEntity.ok(livroService.salvar(livroModel));
        }
        return ResponseEntity.notFound().build();
    }

}
