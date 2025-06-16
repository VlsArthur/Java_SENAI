package com.provapraticaapi.ProvaPraticaAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provapraticaapi.ProvaPraticaAPI.model.LivroModel;
import com.provapraticaapi.ProvaPraticaAPI.repository.LivroRepository;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<LivroModel> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public LivroModel salvar(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
