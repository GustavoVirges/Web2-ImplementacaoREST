package org.example.dao;

import org.example.model.Jogador;

import java.util.List;
import java.util.Optional;

public interface JogadorDao {
    Jogador insert(Jogador jogador);
    Jogador update(Jogador jogador);
    void delete(Jogador jogador);
    Optional<Jogador> findById(Long id);
    List<Jogador> findAll();

    /** Existe outro jogador (id diferente de ignorarId) com esse nome? */
    boolean existsByNome(String nome, Long ignorarId);
}
