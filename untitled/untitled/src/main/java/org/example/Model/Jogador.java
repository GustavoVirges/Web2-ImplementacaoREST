package org.example.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jogador")
    private int id;

<<<<<<< HEAD
    @Column(name = "nome")
    private String nome;
=======
    @Column(name = "nome_jogador", nullable = false, length = 60)
    private String nomeJogador;
>>>>>>> 8de7a54db06588e33a2437ac42b62756f018822c

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_jogador", nullable = false)
    private List<Item> itens = new ArrayList<>();

    @Column(name = "nivel", nullable = false)
    private int nivel;

    @Column(name = "cla", length = 40)
    private String cla;

    @Enumerated(EnumType.STRING)
    @Column(name = "classe", nullable = false, length = 20)
    private ClasseJogador classe;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
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