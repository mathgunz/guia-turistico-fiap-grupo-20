package com.controleguiaturistico.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/controle-guia=turistico")
@RestController
public class ControleGuiaTuristicoController {

    @GetMapping()
    public ResponseEntity teste() {

        return ResponseEntity.ok("Funcionando");
    }
}