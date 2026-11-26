package org.example.dto;

import org.example.model.ClasseJogador;
import org.example.model.Jogador;

import java.util.List;

public record JogadorResponse(Long id, String nome, int nivel, String cla,
                              ClasseJogador classe, List<ItemResponse> itens) {

    public static JogadorResponse de(Jogador j) {
        return new JogadorResponse(j.getId(), j.getNomeJogador(), j.getNivel(), j.getCla(),
                j.getClasse(), j.getItens().stream().map(ItemResponse::de).toList());
    }
}
