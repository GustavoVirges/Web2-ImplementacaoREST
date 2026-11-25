package org.example.dao;

import org.example.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemDao {
    Item insert(Item item);
    Item update(Item item);
    void delete(Item item);
    Optional<Item> findById(Long id);
    List<Item> findAll();

    /** O jogador já tem outro item (id diferente de ignorarId) com esse nome? */
    boolean existsByNomeAndJogador(String nome, Long jogadorId, Long ignorarId);
}
