package com.guia.repositories.entities;

import com.guia.controllers.dtos.EnderecoDTO;

import javax.persistence.*;

@Entity(name = "endereco")
@Table(name="endereco",schema = "guia_fiap")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String cidade;
    private String estado;
    private String endereco;
    private String bairro ;
    private Integer numero;

    public EnderecoEntity(EnderecoDTO endereco) {
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.endereco = endereco.getEndereco();
        this.bairro = endereco.getBairro();
        this.numero = endereco.getNumero();
    }

    public EnderecoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
