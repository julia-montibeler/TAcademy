package com.example.posts.post_params.domain.Consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "consulta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String medico;

    private String paciente;

    private LocalDateTime data;

    public Consulta(ConsultaRequestDTO data){
        this.medico = data.medico();
        this.paciente = data.paciente();
        this.data = data.data();
    }
}
