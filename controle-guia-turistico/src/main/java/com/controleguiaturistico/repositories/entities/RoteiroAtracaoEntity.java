package com.controleguiaturistico.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "roteiroAtracao")
@Table(name = "roteiro_atracao", schema = "controle_guia_fiap")
public class RoteiroAtracaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long atracaoId;
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roteiro_id")
    @JsonIgnore
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

    public void setRoteiro(RoteiroEntity roteiro) {
        this.roteiro = roteiro;
    }
}
