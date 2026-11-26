package org.example.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private int id;

<<<<<<< HEAD
    @Column(name = "nome")
    private String nome;
=======
    @Column(name = "nome_item", nullable = false, length = 60)
    private String nomeItem;
>>>>>>> 8de7a54db06588e33a2437ac42b62756f018822c

    @Enumerated(EnumType.STRING)
    @Column(name = "raridade", nullable = false, length = 20)
    private RaridadeItem raridade;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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