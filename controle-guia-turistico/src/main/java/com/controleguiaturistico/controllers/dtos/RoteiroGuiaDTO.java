package com.controleguiaturistico.controllers.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RoteiroGuiaDTO implements Serializable {

    @ApiModelProperty(value = "Nome da roteiro.", example = "Hopi")
    private String nome;
    @ApiModelProperty(value = "Descrição do roteiro.", example = "Um dia no parque que tem vários brinquedos fechados")
    private String descricao;
    @ApiModelProperty(value = "Data do passeio.")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data;
    @ApiModelProperty(value = "Atrações do roteiro.")
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
