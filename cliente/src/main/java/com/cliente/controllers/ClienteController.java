package com.cliente.controllers;

import com.cliente.repositories.entities.ClienteEntity;
import com.cliente.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(final ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {

        ClienteEntity cliente = clienteService.get(id);
        return ResponseEntity.ok().body(cliente);

    }

    @PostMapping
    public ResponseEntity criar(@RequestBody ClienteEntity cliente){

        ClienteEntity clienteEntity = clienteService.criar(cliente);
        return ResponseEntity.ok().body(clienteEntity);

    }

}