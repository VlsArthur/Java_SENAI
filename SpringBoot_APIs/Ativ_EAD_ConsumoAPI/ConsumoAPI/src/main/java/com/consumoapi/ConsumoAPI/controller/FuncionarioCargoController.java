package com.consumoapi.ConsumoAPI.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consumoapi.ConsumoAPI.model.FuncionarioCargoModel;
import com.consumoapi.ConsumoAPI.service.FuncionarioCargoService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/funcionarios-por-cargo")
public class FuncionarioCargoController {
    @Autowired
    private FuncionarioCargoService funcionarioCargoService;

    @GetMapping
    public List<FuncionarioCargoModel> listarTodos(@RequestParam(required = false) Long funcionarioId, @RequestParam(required = false) Long cargoId) {
        return funcionarioCargoService.listarTodos(funcionarioId, cargoId);
    }

    @GetMapping("{id}")
    public ResponseEntity<FuncionarioCargoModel> detalhar(@PathVariable Long id) {
        if (funcionarioCargoService.procurarPorId(id).isPresent()) {
            return ResponseEntity.ok(funcionarioCargoService.procurarPorId(id).get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public FuncionarioCargoModel criarVinculo(@RequestBody FuncionarioCargoModel funcionarioCargoModel) {
        return funcionarioCargoService.salvar(funcionarioCargoModel);
    }

    @PutMapping("{id}")
    public ResponseEntity<FuncionarioCargoModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioCargoModel funcionarioCargoModel) {
        if (funcionarioCargoService.procurarPorId(id).isPresent()) {
            funcionarioCargoModel.setId(id);
            return ResponseEntity.ok(funcionarioCargoService.salvar(funcionarioCargoModel));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (funcionarioCargoService.procurarPorId(id).isPresent()) {
            funcionarioCargoService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    
}
