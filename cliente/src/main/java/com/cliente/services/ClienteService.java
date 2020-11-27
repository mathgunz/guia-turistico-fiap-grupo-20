package com.cliente.services;

import com.cliente.repositories.ClienteRepository;
import com.cliente.repositories.entities.ClienteEntity;
import com.cliente.repositories.entities.ClienteMapper;
import com.cliente.services.dtos.Cliente;
import com.cliente.usecases.ClienteUseCase;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService implements ClienteUseCase {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente getById(Long id) throws NotFoundException {
        return clienteRepository.findById(id).map(cliente -> new ClienteMapper().toEntity(cliente)).orElse(null);
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
    public ClienteEntity deletar(Long id) throws NotFoundException {

        Optional<ClienteEntity> client = clienteRepository.findById(id);

        if (client.isEmpty()){
            return null;
        }

        clienteRepository.delete(client.get());
        return client.get();
    }

}
