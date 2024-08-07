package com.tacademy.livro.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRecordDto(@NotBlank String titulo, @NotBlank String autor, @NotNull Integer paginas, @NotBlank String editora) {
}
