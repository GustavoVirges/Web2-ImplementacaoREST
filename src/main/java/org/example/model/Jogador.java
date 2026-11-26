
package org.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jogador")
    private Long id;

    @Column(name = "nome_jogador", nullable = false, length = 60)
    private String nomeJogador;

    @OneToMany(
        mappedBy = "jogador",
        cascade = CascadeType.ALL
    )
    private List<Item> itens = new ArrayList<>();

    @Column(name = "nivel", nullable = false)
    private int nivel;

    @Column(name = "cla", length = 40)
    private String cla;

    @Enumerated(EnumType.STRING)
    @Column(name = "classe", nullable = false, length = 20)
    private ClasseJogador classe;

    public Long getId() {
        return id;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        if (item == null) {
            return;
        }

        Jogador jogadorAtual = item.getJogador();

        if (jogadorAtual != null && jogadorAtual != this) {
            jogadorAtual.itens.remove(item);
        }

        if (!itens.contains(item)) {
            itens.add(item);
        }

        item.setJogador(this);
    }

    public void removerItem(Item item) {
        if (item == null) {
            return;
        }

        if (itens.remove(item) && item.getJogador() == this) {
            item.setJogador(null);
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public ClasseJogador getClasse() {
        return classe;
    }

    public void setClasse(ClasseJogador classe) {
        this.classe = classe;
    }
}
