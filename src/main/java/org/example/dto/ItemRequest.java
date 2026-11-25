package org.example.dto;

import jakarta.validation.constraints.*;
import org.example.model.RaridadeItem;

public record ItemRequest(
        @NotBlank(message = "é obrigatório")
        @Size(max = 60, message = "deve ter no máximo 60 caracteres")
        String nome,

        @NotNull(message = "é obrigatório (COMUM, INCOMUM, RARO, EPICO ou LENDARIO)")
        RaridadeItem raridade,

        @NotNull(message = "é obrigatório")
        @Min(value = 1, message = "deve ser no mínimo 1")
        Integer quantidade,

        @NotNull(message = "é obrigatório")
        @Positive(message = "deve ser positivo")
        Long jogadorId) {
}
