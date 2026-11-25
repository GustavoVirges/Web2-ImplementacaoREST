package org.example.Model;

import javax.persistence.*;

@Entity
@Table(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private int id;

    @Column(name = "nome_item", nullable = false, length = 60)
    private String nomeItem;

    @Enumerated(EnumType.STRING)
    @Column(name = "raridade", nullable = false, length = 20)
    private RaridadeItem raridade;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public int getId() { return id; }

    public String getNomeItem() { return nomeItem; }
    public void setNomeItem(String nomeItem) { this.nomeItem = nomeItem; }

    public RaridadeItem getRaridade() { return raridade; }
    public void setRaridade(RaridadeItem raridade) { this.raridade = raridade; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}