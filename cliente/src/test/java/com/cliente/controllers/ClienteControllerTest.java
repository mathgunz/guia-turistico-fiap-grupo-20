package com.cliente.controllers;

import com.cliente.repositories.entities.ClienteEntity;
import com.cliente.services.dtos.Cliente;
import com.cliente.usecases.ClienteUseCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private ClienteController clienteController;

    @MockBean
    private ClienteUseCase clienteUseCase;

    @Mock
    private ClienteEntity clienteEntity;

    @Mock
    private Cliente cliente;

	@Test
    public void salvarTest() {

	    Mockito.when(clienteUseCase.salvar(clienteEntity)).thenReturn(clienteEntity);

        ResponseEntity response = clienteController.salvar(clienteEntity);

        ClienteEntity clienteResponse = (ClienteEntity) response.getBody();
        
        assertEquals(clienteResponse, clienteEntity);
    }

    @Test
    public void getTest() throws Exception {

        Long id = 10l;
        Mockito.when(clienteUseCase.getById(id)).thenReturn(cliente);

        ResponseEntity response = clienteController.get(id);

        Cliente clienteResponse = (Cliente) response.getBody();

        assertEquals(clienteResponse, cliente);
    }


    @Test
    public void getWhenIsNullTest() throws Exception {

        Long id = 10l;
        Mockito.when(clienteUseCase.getById(id)).thenReturn(null);

        ResponseEntity response = clienteController.get(id);

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void atualizarTest() {

        Long id = 10l;

        Mockito.when(clienteUseCase.atualizar(clienteEntity, id)).thenReturn(clienteEntity);

        ResponseEntity response = clienteController.atualizar(clienteEntity, id);

        ClienteEntity clienteResponse = (ClienteEntity) response.getBody();

        assertEquals(clienteResponse, clienteEntity);
    }

    @Test
    public void deleteTest() throws Exception {

        Long id = 10l;

        Mockito.when(clienteUseCase.deletar(id)).thenReturn(clienteEntity);

        ResponseEntity response = clienteController.delete(id);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
