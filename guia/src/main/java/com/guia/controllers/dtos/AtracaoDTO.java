package com.guia.controllers.dtos;

import com.guia.repositories.entities.EnderecoEntity;
import com.guia.repositories.entities.GuiaEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

public class AtracaoDTO implements Serializable {

    @ApiModelProperty(value = "Nome da Atração", example = "Ibirapuera")
    private String nome;
    @ApiModelProperty(value = "Descrição da Atração", example = "Parque Ibirapuera está localizado na zona sul de SP")
    private String descricao;
    @ApiModelProperty(value = "Guia responsavel da Atração", example = "Fernando Souza")
    private GuiaEntity guia;
    @ApiModelProperty(value = "Tipo de Atração", example = "Natureza e Diversao")
    private String tipo;
    @ApiModelProperty(value = "Publico alvo da Atração", example = "Ideal para todas as idades")
    private String publicoAlvo;
    @ApiModelProperty(value = "Valor da Atração", example = "10 reais")
    private String valor;
    @ApiModelProperty(value = "Endereço da Atração", example = "Avenida 23 de maio-SP")
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
