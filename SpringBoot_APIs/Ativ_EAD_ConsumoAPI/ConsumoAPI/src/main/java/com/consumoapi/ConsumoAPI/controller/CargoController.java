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
import org.springframework.web.bind.annotation.RestController;

import com.consumoapi.ConsumoAPI.model.CargoModel;
import com.consumoapi.ConsumoAPI.service.CargoService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cargos")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @GetMapping
    public List<CargoModel> listarTodos() {
        return cargoService.listarTodos();
    }

    @PostMapping
    public CargoModel salvar(@RequestBody CargoModel cargoModel) {
        return cargoService.salvar(cargoModel);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (cargoService.procurarPorId(id).isPresent()) {
            cargoService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<CargoModel> editar(@PathVariable Long id, @RequestBody CargoModel cargoModel) {
        if (cargoService.procurarPorId(id).isPresent()) {
            cargoModel.setId(id);
            return ResponseEntity.ok(cargoService.salvar(cargoModel));
        }
        return ResponseEntity.notFound().build();
    }
}
