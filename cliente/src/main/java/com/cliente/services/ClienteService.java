package com.cliente.services;

import com.cliente.repositories.ClienteRepository;
import com.cliente.repositories.entities.ClienteEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteEntity get(Long id) {

        ClienteEntity cliente = clienteRepository.getOne(id);

        return cliente;

    }

    public ClienteEntity criar(ClienteEntity cliente) {

      ClienteEntity clienteEntity = clienteRepository.save(cliente);

      return clienteEntity;
    }
}
