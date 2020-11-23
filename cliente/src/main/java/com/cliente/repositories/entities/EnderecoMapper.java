package com.cliente.repositories.entities;

import com.cliente.services.entities.Endereco;

public class EnderecoMapper implements BaseMapper<EnderecoEntity, Endereco> {
    @Override
    public Endereco toEntity(EnderecoEntity entity) {
        return new Endereco(
                entity.getId(),
                entity.getCep(),
                entity.getCidade(),
                entity.getEstado(),
                entity.getEndereco(),
                entity.getBairro(),
                entity.getNumero()
        );
    }
}
