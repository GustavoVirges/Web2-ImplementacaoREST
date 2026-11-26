package org.example.dto;

import java.util.List;

public record ErroResponse(String timestamp, int status, String erro, String mensagem,
                           String caminho, List<String> detalhes) {
}
