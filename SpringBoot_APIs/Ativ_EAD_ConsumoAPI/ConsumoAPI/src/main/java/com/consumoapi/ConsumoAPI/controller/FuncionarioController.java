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

import com.consumoapi.ConsumoAPI.model.FuncionarioModel;
import com.consumoapi.ConsumoAPI.service.FuncionarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("api/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioModel> listarTodos() {
        return funcionarioService.ListarTodos();
    }

    @PostMapping
    public FuncionarioModel salvar(@RequestBody FuncionarioModel funcionarioModel) {
        return funcionarioService.salvar(funcionarioModel);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (funcionarioService.ProcurarPorID(id).isPresent()) {
            funcionarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel) {
        if (funcionarioService.ProcurarPorID(id).isPresent()) {
            funcionarioModel.setId(id);
            return ResponseEntity.ok(funcionarioService.salvar(funcionarioModel));
        }
        return ResponseEntity.noContent().build();
    }
}
