package com.controleguiaturistico.controllers.dtos;

import java.io.Serializable;

public class AtracaoDTO implements Serializable {

    private Long id;
    private Long atracaoId;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAtracaoId() {
        return atracaoId;
    }

    public void setAtracaoId(Long atracaoId) {
        this.atracaoId = atracaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
