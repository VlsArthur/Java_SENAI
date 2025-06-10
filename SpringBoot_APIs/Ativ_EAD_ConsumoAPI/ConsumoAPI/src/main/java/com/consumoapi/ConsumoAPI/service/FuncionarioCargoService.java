package com.consumoapi.ConsumoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumoapi.ConsumoAPI.model.FuncionarioCargoModel;
import com.consumoapi.ConsumoAPI.repository.FuncionarioCargoRepository;

@Service
public class FuncionarioCargoService {
    @Autowired
    private FuncionarioCargoRepository funcionarioCargoRepository;

    public List<FuncionarioCargoModel> listarTodos() {
        return funcionarioCargoRepository.findAll();
    }

    public Optional<FuncionarioCargoModel> procurarPorId(Long id) {
        return funcionarioCargoRepository.findById(id);
    }

    public void deletar(Long id) {
        funcionarioCargoRepository.deleteById(id);
    }

    public FuncionarioCargoModel salvar(FuncionarioCargoModel funcionarioCargoModel) {
        return funcionarioCargoRepository.save(funcionarioCargoModel);
    }
}
