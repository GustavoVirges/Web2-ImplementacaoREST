package org.example;

import javax.persistence.*;

public class CadastroJogador {
    public static void main(String... args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Jogadores");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Jogador jogador = new Jogador();
        jogador.setNomeJogador("JOGADOR");

        entityManager.getTransaction().begin();
        entityManager.persist(jogador);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
