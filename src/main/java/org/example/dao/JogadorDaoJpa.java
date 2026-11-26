package org.example.dao;

import java.util.List;
import java.util.Optional;

import org.example.model.Jogador;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class JogadorDaoJpa implements JogadorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Jogador insert(Jogador jogador) {
        em.persist(jogador);
        return jogador;
    }

    @Override
    public Jogador update(Jogador jogador) {
        return em.merge(jogador);
    }

    @Override
    public void delete(Jogador jogador) {
        em.remove(em.contains(jogador) ? jogador : em.merge(jogador));
    }

    @Override
    public Optional<Jogador> findById(Long id) {
        return Optional.ofNullable(em.find(Jogador.class, id));
    }

    @Override
    public List<Jogador> findAll() {
        return em.createQuery(
                "SELECT DISTINCT j FROM Jogador j " +
                "LEFT JOIN FETCH j.itens " +
                "ORDER BY j.id",
                Jogador.class
        ).getResultList();
    }

    @Override
    public boolean existsByNome(String nome, Long ignorarId) {

        Long total = em.createQuery(
                "SELECT COUNT(j) FROM Jogador j " +
                "WHERE LOWER(j.nomeJogador) = LOWER(:nome) " +
                "AND j.id <> :ignorarId",
                Long.class
        )
        .setParameter("nome", nome)
        .setParameter("ignorarId", ignorarId)
        .getSingleResult();

        return total > 0;
    }
}