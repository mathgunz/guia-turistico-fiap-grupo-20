package com.controleguiaturistico.repositories.entities;

import com.controleguiaturistico.controllers.dtos.ClienteDTO;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClienteEntity {

    @Column(name = "cliente_id")
    private Long id;

    @Column(name = "cliente_nome")
    private String nome;

    public ClienteEntity(ClienteDTO cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
    }

    public ClienteEntity() {
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
