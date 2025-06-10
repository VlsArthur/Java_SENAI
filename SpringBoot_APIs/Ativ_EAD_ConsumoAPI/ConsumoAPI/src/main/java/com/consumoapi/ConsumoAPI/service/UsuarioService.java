package com.consumoapi.ConsumoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumoapi.ConsumoAPI.model.UsuarioModel;
import com.consumoapi.ConsumoAPI.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired 
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> ListarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> ProcurarPorID(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel salvar(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
