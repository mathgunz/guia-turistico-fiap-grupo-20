package com.guia.repositories.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class AtracaoEntity {

    private String nome;
    private String descricao;

    @ManyToOne()
    @JoinColumn(name="guia_id", nullable=false)
    private GuiaEntity guia;
    private String tipo;
    private String publico_alvo;
    private String valor;
    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

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

    public String getPublico_alvo() {
        return publico_alvo;
    }

    public void setPublico_alvo(String publico_alvo) {
        this.publico_alvo = publico_alvo;
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
