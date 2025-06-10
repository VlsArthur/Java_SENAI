package com.consumoapi.ConsumoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumoapi.ConsumoAPI.model.FuncionarioModel;
import com.consumoapi.ConsumoAPI.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired 
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioModel> ListarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioModel> ProcurarPorID(Long id) {
        return funcionarioRepository.findById(id);
    }

    public FuncionarioModel salvar(FuncionarioModel funcionarioModel) {
        return funcionarioRepository.save(funcionarioModel);
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
