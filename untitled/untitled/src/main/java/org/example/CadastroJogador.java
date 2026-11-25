
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

        Item item1 = new Item();
        item1.setNome("Item 1");
        item1.setQuantidade(64);
        item1.setRaridade(RaridadeItem.COMUM);

        Item item2 = new Item();
        item2.setNome("Item 2");
        item2.setQuantidade(32);
        item2.setRaridade(RaridadeItem.LENDARIO);

        Jogador jogador = new Jogador();
        jogador.setNome("JOGADOR");
        jogador.setCla("cla");
        jogador.setNivel(10);
        jogador.setClasse(ClasseJogador.ESPADA);

        jogador.adicionarItem(item1);
        jogador.adicionarItem(item2);

        entityManager.getTransaction().begin();

        entityManager.persist(jogador);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
