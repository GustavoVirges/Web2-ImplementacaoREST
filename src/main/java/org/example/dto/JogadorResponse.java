package org.example.dto;

import java.util.List;

import org.example.model.ClasseJogador;
import org.example.model.Jogador;

public record JogadorResponse(
        Long id,
        String nome,
        int nivel,
        String cla,
        ClasseJogador classe,
        List<ItemResponse> itens
) {

    public static JogadorResponse de(Jogador jogador) {
        return new JogadorResponse(
                jogador.getId(),
                jogador.getNomeJogador(),
                jogador.getNivel(),
                jogador.getCla(),
                jogador.getClasse(),
                jogador.getItens()
                        .stream()
                        .map(ItemResponse::de)
                        .toList()
        );
    }
}