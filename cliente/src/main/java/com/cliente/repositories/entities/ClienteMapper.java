package com.cliente.repositories.entities;

import com.cliente.services.dtos.Cliente;

public class ClienteMapper implements BaseMapper<ClienteEntity, Cliente> {

    @Override
    public Cliente toEntity(ClienteEntity entity) {
        return Cliente.newBuilder()
                .setId(entity.getId())
                .setCpf(entity.getCpf())
                .setEmail(entity.getEmail())
                .setEndereco(entity.getEndereco() != null ? new EnderecoMapper().toEntity(entity.getEndereco()) : null)
                .setNome(entity.getNome())
                .setTelefone(entity.getTelefone())
                .build();
    }
}
