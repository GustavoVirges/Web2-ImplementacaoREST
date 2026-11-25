package org.example.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jogador")
    private int id;

    @Column(name = "nome_jogador", nullable = false, length = 60)
    private String nomeJogador;

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