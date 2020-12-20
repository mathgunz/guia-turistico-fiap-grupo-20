package com.cliente.services.dtos;

import java.io.Serializable;

public class Cliente implements Serializable {
    private Long id;
    private String nome;
    private String cpf;
    private Long telefone;
    private String email;
    private Endereco endereco;

    private Cliente(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.cpf = builder.cpf;
        this.telefone = builder.telefone;
        this.email = builder.email;
        this.endereco = builder.endereco;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String nome;
        private String cpf;
        private Long telefone;
        private String email;
        private Endereco endereco;

        private Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder setTelefone(Long telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setEndereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder of(Cliente cliente) {
            this.id = cliente.id;
            this.nome = cliente.nome;
            this.cpf = cliente.cpf;
            this.telefone = cliente.telefone;
            this.email = cliente.email;
            this.endereco = cliente.endereco;
            return this;
        }

        public Cliente build() {
            return new Cliente(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
