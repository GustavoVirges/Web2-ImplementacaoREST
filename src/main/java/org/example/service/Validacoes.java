package org.example.service;

import org.example.exception.RequisicaoInvalidaException;

public final class Validacoes {

    private Validacoes() {
    }

    public static void validarId(Long id) {
        if (id == null || id <= 0) {
            throw new RequisicaoInvalidaException(
                "Id inválido: " + id
            );
        }
    }
}