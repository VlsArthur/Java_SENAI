package com.provapraticaapi.ProvaPraticaAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provapraticaapi.ProvaPraticaAPI.model.BibliotecarioModel;
import com.provapraticaapi.ProvaPraticaAPI.repository.BibliotecarioRepository;

@Service
public class BibliotecarioService {
    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public List<BibliotecarioModel> listarTodos() {
        return bibliotecarioRepository.findAll();
    }

    public Optional<BibliotecarioModel> buscarPorId(Long id) {
        return bibliotecarioRepository.findById(id);
    }

    public BibliotecarioModel salvar(BibliotecarioModel bibliotecarioModel) {
        return bibliotecarioRepository.save(bibliotecarioModel);
    }

    public void deletar(Long id) {
        bibliotecarioRepository.deleteById(id);
    }
}
