package com.controleguiaturistico.repositories.entities;

import com.controleguiaturistico.controllers.dtos.GuiaDTO;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GuiaEntity {

    @Column(name = "guia_id")
    private Long id;
    @Column(name = "guia_nome")
    private String nome;

    public GuiaEntity(GuiaDTO guia) {
        this.id = guia.getId();
        this.nome = guia.getNome();
    }

    public GuiaEntity() {
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
