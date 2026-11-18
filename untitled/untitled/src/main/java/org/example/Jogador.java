package org.example;

import javax.persistence.*;

@Entity
@Table(name = "jogador")
public class Jogador {

    @Id
    @Column(name = "id_jogador")
    // auto increment a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nomeJogador;

    @Column(name = "nivel")
    private int nivel;

    @Column(name = "cla")
    private String cla;

    @Column(name = "classe")
    private ClasseJogador classe;


    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
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
