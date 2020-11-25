package com.controleguiaturistico.controllers.dtos;

import java.io.Serializable;

public class GuiaDTO implements Serializable {

    private Long id;
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
