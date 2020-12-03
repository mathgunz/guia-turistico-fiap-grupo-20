package com.guia.controllers.dtos;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class EnderecoDTO implements Serializable {

    @ApiModelProperty(value = "Identificador do Endereço ", example = "1")
    private Long id;
    @ApiModelProperty(value = "CEP do Endereço ", example = "35621-221")
    private String cep;
    @ApiModelProperty(value = "Cidade do Endereço ", example = "São Paulo")
    private String cidade;
    @ApiModelProperty(value = "Estado do Endereço ", example = "São Paulo")
    private String estado;
    @ApiModelProperty(value = "Nome do Endereço ", example = "Avenida 23 de maio")
    private String endereco;
    @ApiModelProperty(value = "Bairro do Endereço ", example = "Vila Mariana")
    private String bairro ;
    @ApiModelProperty(value = "Numero do Endereço ", example = "15236")
    private Integer numero;

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
