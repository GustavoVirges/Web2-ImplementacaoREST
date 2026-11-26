package org.example.dto;

import org.example.model.Item;
import org.example.model.RaridadeItem;

public record ItemResponse(
        Long id,
        String nome,
        RaridadeItem raridade,
        int quantidade,
        Long jogadorId
) {

    public static ItemResponse de(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getNomeItem(),
                item.getRaridade(),
                item.getQuantidade(),
                item.getJogador().getId()
        );
    }
}