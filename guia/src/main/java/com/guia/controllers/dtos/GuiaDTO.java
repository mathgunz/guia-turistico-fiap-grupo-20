package com.guia.controllers.dtos;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class GuiaDTO implements Serializable {


    @ApiModelProperty(value = "Identificador do Guia ", example = "1")
    private Long id;

    @ApiModelProperty(value = "Nome Completo do Guia ", example = "Fernado Souza Aguiar")
    private String nome;

    @ApiModelProperty(value = "CPF do Guia", example = "39956471254")
    private String cpf;

    @ApiModelProperty(value = "E-mail do guia", example = "fernando@guia.com.br")
    private String email;

    @ApiModelProperty(value = "Telefone do guia", example = "11954741254")
    private Long telefone;

    @ApiModelProperty(value = "Endereço do guia", example = "Avenida Paulista")
    private EnderecoDTO endereco;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
