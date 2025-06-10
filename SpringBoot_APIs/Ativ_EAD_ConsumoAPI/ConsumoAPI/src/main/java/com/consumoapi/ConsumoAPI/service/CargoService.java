package com.consumoapi.ConsumoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.consumoapi.ConsumoAPI.model.CargoModel;
import com.consumoapi.ConsumoAPI.repository.CargoRepository;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public List<CargoModel> listarTodos() {
        return cargoRepository.findAll();
    }

    public Optional<CargoModel> procurarPorId(Long id) {
        return cargoRepository.findById(id);
    }

    public CargoModel salvar(@RequestBody CargoModel cargoModel) {
        return cargoRepository.save(cargoModel);
    }

    public void deletar(Long id) {
        cargoRepository.deleteById(id);
    }
}
