package com.controleguiaturistico.repositories.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "roteiro")
@Table(name = "roteiro", schema = "controle_guia_fiap")
public class RoteiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Date criacao;

    @OneToMany(mappedBy = "roteiro")
    private List<RoteiroAtracao> atracoes;

    @ManyToOne
    @JoinColumn(name="contratacao_id", nullable=false)
    private ControleGuiaTuristicoEntity controle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public ControleGuiaTuristicoEntity getControle() {
        return controle;
    }

    public void setControle(ControleGuiaTuristicoEntity controle) {
        this.controle = controle;
    }

    public List<RoteiroAtracao> getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(List<RoteiroAtracao> atracoes) {
        this.atracoes = atracoes;
    }
}
