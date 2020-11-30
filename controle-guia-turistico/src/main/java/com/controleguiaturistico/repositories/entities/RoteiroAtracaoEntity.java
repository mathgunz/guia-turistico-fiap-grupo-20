package com.controleguiaturistico.repositories.entities;

import javax.persistence.*;


@Entity(name = "roteiroAtracao")
@Table(name = "roteiro_atracao", schema = "controle_guia_fiap")
public class RoteiroAtracaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long atracaoId;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "roteiro_id")
    private RoteiroEntity roteiro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAtracaoId() {
        return atracaoId;
    }

    public void setAtracaoId(Long atracaoId) {
        this.atracaoId = atracaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RoteiroEntity getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(RoteiroEntity roteiro) {
        this.roteiro = roteiro;
    }
}
