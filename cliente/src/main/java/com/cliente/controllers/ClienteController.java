package com.cliente.controllers;

import com.cliente.repositories.entities.ClienteEntity;
import com.cliente.services.entities.Cliente;
import com.cliente.usecases.ClienteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(final ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    //METODO BUSCAR ID USUARIO
    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") Long id) throws Exception {
        Cliente cliente = clienteUseCase.getById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody ClienteEntity cliente){
        ClienteEntity clienteEntity = clienteUseCase.salvar(cliente);
        return ResponseEntity.ok().body(clienteEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@RequestBody ClienteEntity cliente, @PathVariable("id") Long id) {
        ClienteEntity clienteEntity = clienteUseCase.atualizar(cliente, id);
        return ResponseEntity.ok().body(clienteEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws Exception {
        ClienteEntity clienteEntity = clienteUseCase.deletar(id);
        return ResponseEntity.ok().body("Cliente " + clienteEntity.getNome() + " deletado com sucesso");
    }

}