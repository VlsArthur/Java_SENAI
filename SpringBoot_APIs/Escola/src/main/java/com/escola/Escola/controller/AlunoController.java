package com.escola.Escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.Escola.model.Aluno;
import com.escola.Escola.service.AlunoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        if (alunoService.buscarPorId(id).isPresent()) {
            aluno.setId(id);
            return ResponseEntity.ok(alunoService.salvar(aluno));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (alunoService.buscarPorId(id).isPresent()) {
            alunoService.excluir(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
