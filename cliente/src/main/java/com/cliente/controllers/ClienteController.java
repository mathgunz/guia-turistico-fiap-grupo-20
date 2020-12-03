package com.cliente.controllers;

import com.cliente.repositories.entities.ClienteEntity;
import com.cliente.services.dtos.Cliente;
import com.cliente.usecases.ClienteUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clientes")
@RestController
@Api(tags = "CRUD de Cliente")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(final ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @ApiOperation(value = "Buscar usuário pelo ID.")
    @GetMapping("{clienteId}")
    public ResponseEntity get(@PathVariable("clienteId") Long id) throws Exception {
        Cliente cliente = clienteUseCase.getById(id);
        return cliente != null ? ResponseEntity.ok().body(cliente) : ResponseEntity.notFound().build();
    }
    @ApiOperation(value = "Criar usuário.")
    @PostMapping
    public ResponseEntity salvar(@RequestBody ClienteEntity cliente){
        ClienteEntity clienteEntity = clienteUseCase.salvar(cliente);
        return ResponseEntity.ok().body(clienteEntity);
    }
    @ApiOperation(value = "Atualizar usuário.")
    @PutMapping("{clienteId}")
    public ResponseEntity atualizar(@RequestBody ClienteEntity cliente, @PathVariable("clienteId") Long id) {
        ClienteEntity clienteEntity = clienteUseCase.atualizar(cliente, id);
        return ResponseEntity.ok().body(clienteEntity);
    }
    @ApiOperation(value = "Deletar usuário.")
    @DeleteMapping("{clienteId}")
    public ResponseEntity delete(@PathVariable("clienteId") Long id) throws Exception {
        ClienteEntity clienteEntity = clienteUseCase.deletar(id);
        return clienteEntity != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}