package org.example;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    // auto increment a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nomeItem;

    @Column(name = "raridade")
    private RaridadeItem raridade;

    @Column(name = "quantidade")
    private int quantidade;


    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public RaridadeItem getRaridade() {
        return raridade;
    }

    public void setRaridade(RaridadeItem raridade) {
        this.raridade = raridade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
