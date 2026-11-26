package org.example.dto;

import org.example.model.ClasseJogador;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
        ClasseJogador classe

) {
}