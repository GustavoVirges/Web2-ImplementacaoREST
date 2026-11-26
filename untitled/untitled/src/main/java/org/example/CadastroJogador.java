
package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.Model.ClasseJogador;
import org.example.Model.Item;
import org.example.Model.Jogador;
import org.example.Model.RaridadeItem;

public class CadastroJogador {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("Jogadores");

        EntityManager entityManager =
                entityManagerFactory.createEntityManager();

        try {
            Item item1 = new Item();
            item1.setNomeItem("Item 1");
            item1.setQuantidade(64);
            item1.setRaridade(RaridadeItem.COMUM);

            Item item2 = new Item();
            item2.setNomeItem("Item 2");
            item2.setQuantidade(32);
            item2.setRaridade(RaridadeItem.LENDARIO);

            Jogador jogador = new Jogador();
            jogador.setNomeJogador("JOGADOR");
            jogador.setCla("cla");
            jogador.setNivel(10);
            jogador.setClasse(ClasseJogador.ESPADA);

            jogador.adicionarItem(item1);
            jogador.adicionarItem(item2);

            entityManager.getTransaction().begin();

            entityManager.persist(jogador);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            throw new RuntimeException("Erro ao cadastrar jogador.", e);

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
