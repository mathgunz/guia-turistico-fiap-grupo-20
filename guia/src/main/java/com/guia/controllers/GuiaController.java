package com.guia.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/guias")
@RestController
public class GuiaController {

    @GetMapping()
    public ResponseEntity teste() {

        return ResponseEntity.ok("Funcionando");
    }
}