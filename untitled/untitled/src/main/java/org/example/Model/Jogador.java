package org.example.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jogador")
public class Jogador {

    @Id
    @Column(name = "id_jogador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nomeJogador;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_jogador")
    private List<Item> itens = new ArrayList<>();

    @Column(name = "nivel")
    private int nivel;

    @Column(name = "cla")
    private String cla;

    @Enumerated(EnumType.STRING)
    @Column(name = "classe")
    private ClasseJogador classe;

    public int getId() { return id; }

    public String getNomeJogador() { return nomeJogador; }
    public void setNomeJogador(String nomeJogador) { this.nomeJogador = nomeJogador; }

    public List<Item> getItens() { return itens; }

    public void adicionarItem(Item item) { itens.add(item); }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public String getCla() { return cla; }
    public void setCla(String cla) { this.cla = cla; }

    public ClasseJogador getClasse() { return classe; }
    public void setClasse(ClasseJogador classe) { this.classe = classe; }
}