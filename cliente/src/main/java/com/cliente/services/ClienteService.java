package com.cliente.services;

import com.cliente.repositories.ClienteRepository;
import com.cliente.repositories.entities.ClienteEntity;
import com.cliente.repositories.entities.ClienteMapper;
import com.cliente.services.dtos.Cliente;
import com.cliente.usecases.ClienteUseCase;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteUseCase {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente getById(Long id) {
        return clienteRepository.findById(id)
                .map( optional -> {
                    return new ClienteMapper().toEntity(optional);
                }).orElseThrow(() -> new RuntimeException("Cliente não existe"));
    }

    @Override
    public ClienteEntity salvar(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteEntity atualizar(ClienteEntity cliente, Long id) {
        clienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cliente não existe"));

        cliente.setId(id);
        clienteRepository.save(cliente);

        return cliente;
    }
    @Override
    public ClienteEntity deletar(Long id) {
        ClienteEntity client = clienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cliente não existe"));

        clienteRepository.deleteById(id);
        return client;
    }

}
