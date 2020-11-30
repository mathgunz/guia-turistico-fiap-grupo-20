package com.controleguiaturistico.controllers.dtos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RoteiroGuiaDTO implements Serializable {

    private String nome;
    private String descricao;
    private Date data;
    private List<AtracaoDTO> atracoes;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<AtracaoDTO> getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(List<AtracaoDTO> atracoes) {
        this.atracoes = atracoes;
    }
}
