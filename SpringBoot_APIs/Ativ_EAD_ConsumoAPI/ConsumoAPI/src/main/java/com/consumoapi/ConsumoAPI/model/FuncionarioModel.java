package com.consumoapi.ConsumoAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="funcionarios")
@Getter
@Setter
@NoArgsConstructor
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nome;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String senha;

    @Column(nullable=false)
    private String cep;

    @Column(nullable=false)
    private String logradouro;

    @Column(nullable=false)
    private String numero;

    @Column
    private String complemento;

    @Column(nullable=false)
    private String bairro;

    @Column(nullable=false)
    private String cidade;

    @Column(nullable=false)
    private String estado;
}


/*
● Campos do Formulário:
○ Nome
○ Email
○ Senha
○ CEP
○ Endereço
○ Número
○ Bairro
○ Cidade
○ Estado
 */