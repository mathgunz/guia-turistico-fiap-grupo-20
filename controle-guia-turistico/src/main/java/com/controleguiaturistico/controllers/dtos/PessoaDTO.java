package com.controleguiaturistico.controllers.dtos;

import io.swagger.annotations.ApiModelProperty;

public abstract class PessoaDTO {

    @ApiModelProperty(value = "Identificador.", example = "25")
    private Long id;
    @ApiModelProperty(value = "Nome.", example = "Natalia")
    private String nome;

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
