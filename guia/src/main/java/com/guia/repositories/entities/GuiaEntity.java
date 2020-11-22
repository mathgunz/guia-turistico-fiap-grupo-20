package com.guia.repositories.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "guia", schema = "guia_fiap")
public class GuiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Long telefone;

    @OneToMany(mappedBy = "guia", cascade = CascadeType.ALL)
    private List<AtracaoEntity> atracoes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

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

    public List<AtracaoEntity> getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(List<AtracaoEntity> atracoes) {
        this.atracoes = atracoes;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
