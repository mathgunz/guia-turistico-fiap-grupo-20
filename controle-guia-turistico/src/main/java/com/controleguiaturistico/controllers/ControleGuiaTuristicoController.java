package com.controleguiaturistico.controllers;

import com.controleguiaturistico.controllers.dtos.ControleGuiaDTO;
import com.controleguiaturistico.repositories.entities.ControleGuiaTuristicoEntity;
import com.controleguiaturistico.services.ControleGuiaTuristicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("controle-guia-turistico")
@RestController
public class ControleGuiaTuristicoController {

    private final ControleGuiaTuristicoService service;

    public ControleGuiaTuristicoController(ControleGuiaTuristicoService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity contratar(@RequestBody ControleGuiaDTO controleGuiaDTO) {

        ControleGuiaTuristicoEntity controleGuia = this.service.contratar(controleGuiaDTO);

        return ResponseEntity.ok(controleGuia);
    }
}