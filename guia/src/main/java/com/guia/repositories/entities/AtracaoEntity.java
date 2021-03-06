package com.guia.repositories.entities;

import com.guia.controllers.dtos.AtracaoDTO;

import javax.persistence.*;

@Entity(name = "atracao")
@Table(name="atracao",schema = "guia_fiap")
public class AtracaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @ManyToOne()
    @JoinColumn(name="guia_id", nullable=false)
    private GuiaEntity guia;
    private String tipo;
    private String publicoAlvo;
    private String valor;
    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

    public AtracaoEntity() {
    }

    public AtracaoEntity(GuiaEntity guia, AtracaoDTO atracaoDTO) {
        this.guia = guia;
        this.descricao = atracaoDTO.getDescricao();
        this.endereco = atracaoDTO.getEndereco();
        this.nome = atracaoDTO.getNome();
        this.publicoAlvo = atracaoDTO.getPublicoAlvo();
        this.tipo = atracaoDTO.getTipo();
        this.valor = atracaoDTO.getValor();
    }

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

    public GuiaEntity getGuia() {
        return guia;
    }

    public void setGuia(GuiaEntity guia) {
        this.guia = guia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
