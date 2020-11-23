package com.cliente.repositories.entities;

import com.cliente.services.entities.Cliente;

public class ClienteMapper implements BaseMapper<ClienteEntity, Cliente> {

    @Override
    public Cliente toEntity(ClienteEntity entity) {
        return new Cliente(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getTelefone(),
                entity.getEmail(),
                entity.getEndereco() != null ? new EnderecoMapper().toEntity(entity.getEndereco()) : null
        );
    }
}
