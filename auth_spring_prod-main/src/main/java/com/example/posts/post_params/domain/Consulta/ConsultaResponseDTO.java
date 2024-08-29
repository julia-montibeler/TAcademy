package com.example.posts.post_params.domain.Consulta;


import java.time.LocalDateTime;

public record ConsultaResponseDTO(String id, String medico, String paciente, LocalDateTime data) {
    public ConsultaResponseDTO(Consulta consulta){
        this(consulta.getId(), consulta.getMedico(), consulta.getPaciente(), consulta.getData());
    }
}