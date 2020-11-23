package com.cliente.usecases;

import com.cliente.repositories.entities.ClienteEntity;
import com.cliente.services.entities.Cliente;

public interface ClienteUseCase {

    Cliente getById(Long id) throws Exception;

    ClienteEntity salvar(ClienteEntity cliente);

    ClienteEntity deletar(Long id) throws Exception;

    ClienteEntity atualizar(ClienteEntity cliente,Long id);


}
