package org.example;

import org.example.Model.ClasseJogador;
import org.example.Model.Item;
import org.example.Model.Jogador;
import org.example.Model.RaridadeItem;

import javax.persistence.*;

public class CadastroJogador {
    public static void main(String... args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Jogadores");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Item item1 = new Item();
        item1.setNomeItem("item1");
        item1.setQuantidade(64);
        item1.setRaridade(RaridadeItem.COMUM);

        Item item2 = new Item();
        item2.setNomeItem("item2");
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
        entityManager.persist(jogador); // o cascade salva os itens junto
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}