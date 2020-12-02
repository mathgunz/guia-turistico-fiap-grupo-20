package com.controleguiaturistico.controllers.dtos;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    @ApiModelProperty(value = "Identificação do cliente.", example = "1")
    private Long id;
    @ApiModelProperty(value = "Nome do cliente.", example = "Matheus")
    private String nome;

    public ClienteDTO() {
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
}
