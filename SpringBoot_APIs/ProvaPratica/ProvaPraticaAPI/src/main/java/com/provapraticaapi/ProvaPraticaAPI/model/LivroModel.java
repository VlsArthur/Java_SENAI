package com.provapraticaapi.ProvaPraticaAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "livros")
@Getter
@Setter
@NoArgsConstructor
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bibliotecario_id")
    private BibliotecarioModel bibliotecario;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String genero;

    @Column
    private String status;

    @Column
    private java.time.LocalDate data_cadastro;

    @PrePersist
    private void PrePersist() {
        this.data_cadastro = java.time.LocalDate.now();

        if (status==null) {
            this.status = "Disponível";
        }
    }
}
