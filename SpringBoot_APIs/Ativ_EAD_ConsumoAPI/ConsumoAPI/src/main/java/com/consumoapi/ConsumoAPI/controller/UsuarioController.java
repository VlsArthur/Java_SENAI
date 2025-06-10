package com.consumoapi.ConsumoAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumoapi.ConsumoAPI.model.UsuarioModel;
import com.consumoapi.ConsumoAPI.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModel> listarTodos() {
        return usuarioService.ListarTodos();
    }

    @PostMapping
    public UsuarioModel salvar(@RequestBody UsuarioModel usuarioModel) {
        return usuarioService.salvar(usuarioModel);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (usuarioService.ProcurarPorID(id).isPresent()) {
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizar(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
        if (usuarioService.ProcurarPorID(id).isPresent()) {
            usuarioModel.setId(id);
            return ResponseEntity.ok(usuarioService.salvar(usuarioModel));
        }
        return ResponseEntity.noContent().build();
    }
}
