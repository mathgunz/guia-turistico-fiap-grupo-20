package com.cliente.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

    @GetMapping()
    public ResponseEntity abrirChamado() {

        return ResponseEntity.ok("Funcionando");
    }
}