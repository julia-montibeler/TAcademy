package com.app.d.e.v.s.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mutante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MutanteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String poder;
    private int idade;
    private int aliensMortos;
    private int demoniosMortos;

    private boolean naInstituicao;
}
