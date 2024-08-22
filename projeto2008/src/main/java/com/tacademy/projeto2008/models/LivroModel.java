package com.tacademy.projeto2008.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "livro")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String autor;
    private String categoria;
    private BigDecimal preco;
}
