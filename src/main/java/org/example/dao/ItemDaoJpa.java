package org.example.dao;

import java.util.List;
import java.util.Optional;

import org.example.model.Item;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ItemDaoJpa implements ItemDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Item insert(Item item) {
        em.persist(item);
        return item;
    }

    @Override
    public Item update(Item item) {
        return em.merge(item);
    }

    @Override
    public void delete(Item item) {
        em.remove(em.contains(item) ? item : em.merge(item));
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(em.find(Item.class, id));
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery(
                "SELECT i FROM Item i ORDER BY i.id",
                Item.class
        ).getResultList();
    }

    @Override
    public boolean existsByNomeAndJogador(
            String nome,
            Long jogadorId,
            Long ignorarId) {

        Long total = em.createQuery(
                "SELECT COUNT(i) FROM Item i " +
                "WHERE LOWER(i.nomeItem) = LOWER(:nome) " +
                "AND i.jogador.id = :jogadorId " +
                "AND i.id <> :ignorarId",
                Long.class
        )
        .setParameter("nome", nome)
        .setParameter("jogadorId", jogadorId)
        .setParameter("ignorarId", ignorarId)
        .getSingleResult();

        return total > 0;
    }
}