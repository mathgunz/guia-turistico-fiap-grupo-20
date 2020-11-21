package com.controleguiaturistico.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GuiaEntity {

    @Column(name = "guia_id")
    private String guiaId;
    @Column(name = "guia_nome")
    private String nome;

    public String getGuiaId() {
        return guiaId;
    }

    public void setGuiaId(String guiaId) {
        this.guiaId = guiaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
