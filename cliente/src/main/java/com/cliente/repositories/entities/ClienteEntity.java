package com.cliente.repositories.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity(name = "cliente")
@Table(name="cliente",schema = "cliente_fiap")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "Nome do Cliente.", example = "Thais")
    private String nome;
    @ApiModelProperty(value = "CPF do Cliente.", example = "363760768-10")
    private String cpf;
    @ApiModelProperty(value = "Telefone do Cliente.", example = "11964566300")
    private Long telefone;
    @ApiModelProperty(value = "E-mail do Cliente.", example = "thais-teste@gmail.com")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @ApiModelProperty(value = "Endereço do Cliente.")
    private EnderecoEntity endereco;


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

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public ClienteEntity() {
        //Hibernate
    }

    public ClienteEntity(Long id, String nome, String cpf, Long telefone, String email, EnderecoEntity endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
}
