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

import com.provapraticaapi.ProvaPraticaAPI.model.BibliotecarioModel;
import com.provapraticaapi.ProvaPraticaAPI.service.BibliotecarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/bibliotecarios")
public class BibliotecarioController {
    @Autowired
    private BibliotecarioService bibliotecarioService;

    @GetMapping
    public List<BibliotecarioModel> listarTodos() {
        return bibliotecarioService.listarTodos();
    }

    @PostMapping
    public BibliotecarioModel salvar(@RequestBody BibliotecarioModel bibliotecarioModel) {
        return bibliotecarioService.salvar(bibliotecarioModel);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (bibliotecarioService.buscarPorId(id).isPresent()) {
            bibliotecarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<BibliotecarioModel> atualizar(@PathVariable Long id, @RequestBody BibliotecarioModel bibliotecarioModel) {
        if (bibliotecarioService.buscarPorId(id).isPresent()) {
            bibliotecarioModel.setId(id);
            return ResponseEntity.ok(bibliotecarioService.salvar(bibliotecarioModel));
        }
        return ResponseEntity.notFound().build();
    }

}
