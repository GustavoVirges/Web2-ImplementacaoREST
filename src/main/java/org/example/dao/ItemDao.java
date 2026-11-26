package org.example.dao;

import java.util.List;
import java.util.Optional;

import org.example.model.Item;

public interface ItemDao {

    Item insert(Item item);

    Item update(Item item);

    void delete(Item item);

    Optional<Item> findById(Long id);

    List<Item> findAll();

    boolean existsByNomeAndJogador(
            String nome,
            Long jogadorId,
            Long ignorarId
    );
}