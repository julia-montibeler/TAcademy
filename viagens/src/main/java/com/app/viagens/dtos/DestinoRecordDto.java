package com.app.viagens.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DestinoRecordDto(@NotNull Long id, @NotBlank String nome) {
}
