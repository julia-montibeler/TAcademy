package com.example.posts.post_params.domain.Consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequestDTO(
        @NotBlank
        String medico,
        @NotBlank
        String paciente,
        @NotNull
        LocalDateTime data
)  {
}
