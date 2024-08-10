package com.app.viagens.dtos;

import com.app.viagens.models.DestinoModel;
import jakarta.validation.constraints.NotNull;

public record ViagemRecordDto(@NotNull Long id, @NotNull DestinoModel destinoModel) {
}
