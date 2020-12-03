package com.cliente.repositories.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity(name = "endereco")
@Table(name="endereco",schema = "cliente_fiap")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "CEP do Cliente.", example = "05588-000")
    private String cep;
    @ApiModelProperty(value = "Cidade do Cliente.", example = "São Paulo")
    private String cidade;
    @ApiModelProperty(value = "Estado do Cliente.", example = "SP")
    private String estado;
    @ApiModelProperty(value = "Endereço do Cliente.", example = "Avenida Brasil")
    private String endereco;
    @ApiModelProperty(value = "Bairro do Cliente.", example = "Jd. Esmeralda")
    private String bairro ;
    @ApiModelProperty(value = "Número da casa.", example = "25")
    private Integer numero;

    public EnderecoEntity() {
    }

    public EnderecoEntity(Long id, String cep, String cidade, String estado, String endereco, String bairro, Integer numero) {
        this.id = id;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numero = numero;
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
