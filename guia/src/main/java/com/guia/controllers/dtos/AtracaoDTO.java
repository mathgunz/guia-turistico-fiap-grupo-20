package com.guia.controllers.dtos;

import com.guia.repositories.entities.EnderecoEntity;
import com.guia.repositories.entities.GuiaEntity;

import javax.persistence.*;
import java.io.Serializable;

public class AtracaoDTO implements Serializable {

    private String nome;
    private String descricao;
    private GuiaEntity guia;
    private String tipo;
    private String publicoAlvo;
    private String valor;
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
