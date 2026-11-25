package org.example.dto;

import jakarta.validation.constraints.*;
import org.example.model.ClasseJogador;

public record JogadorRequest(
        @NotBlank(message = "é obrigatório")
        @Size(max = 60, message = "deve ter no máximo 60 caracteres")
        String nome,

        @NotNull(message = "é obrigatório")
        @Min(value = 1, message = "deve ser no mínimo 1")
        @Max(value = 100, message = "deve ser no máximo 100")
        Integer nivel,

        @Size(max = 40, message = "deve ter no máximo 40 caracteres")
        String cla,

        @NotNull(message = "é obrigatório (ESPADA, ARCO, TANK, MAGO ou CURANDEIRO)")
        ClasseJogador classe) {
}
