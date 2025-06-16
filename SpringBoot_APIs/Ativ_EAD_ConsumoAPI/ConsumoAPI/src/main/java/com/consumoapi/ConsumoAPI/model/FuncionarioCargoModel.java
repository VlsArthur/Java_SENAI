package com.consumoapi.ConsumoAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionario_cargo")
@Getter
@Setter
@NoArgsConstructor
public class FuncionarioCargoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "funcionario_id", nullable = false)
    private FuncionarioModel funcionario;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private CargoModel cargo;

    @Column(length = 1000)
    private String detalhes;

    @Column(nullable = false)
    private java.time.LocalDate data_inicio;

    @PrePersist
    public void prePersist() {
        if (this.data_inicio == null) {
            this.data_inicio = java.time.LocalDate.now();
        }
    }

    @Column
    private java.time.LocalDate data_fim;
}
