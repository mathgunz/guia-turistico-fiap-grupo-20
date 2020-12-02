package com.controleguiaturistico.controllers.dtos;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class GuiaDTO implements Serializable {

    @ApiModelProperty(value = "Identificador do guia.", example = "25")
    private Long id;
    @ApiModelProperty(value = "Nome do guia.", example = "Natalia")
    private String nome;

    public GuiaDTO() {
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
