package com.controleguiaturistico.controllers;

import com.controleguiaturistico.controllers.dtos.ControleGuiaDTO;
import com.controleguiaturistico.repositories.entities.ControleGuiaStatus;
import com.controleguiaturistico.repositories.entities.ControleGuiaTuristicoEntity;
import com.controleguiaturistico.services.ControleGuiaTuristicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class ControleGuiaTuristicoController {

    private final ControleGuiaTuristicoService service;

    public ControleGuiaTuristicoController(ControleGuiaTuristicoService service) {
        this.service = service;
    }

    @PostMapping("agendamentos")
    public ResponseEntity contratar(@RequestBody ControleGuiaDTO controleGuiaDTO) {

        ControleGuiaTuristicoEntity controleGuia = this.service.contratar(controleGuiaDTO);

        return ResponseEntity.ok(controleGuia);
    }

    @GetMapping("/guias/{guiaId}/agendamentos/{agendamentoId}")
    public ResponseEntity contratar(@PathVariable("guiaId") Long guiaId, @PathVariable("agendamentoId") Long agendamentoId) {

        ControleGuiaTuristicoEntity controleGuia = this.service.findById(guiaId, agendamentoId);

        return ResponseEntity.ok(controleGuia);
    }

    @GetMapping("/guias/{guiaId}/agendamentos")
    public ResponseEntity consultar(@PathVariable("guiaId") Long guiaId,
                                    @RequestParam(value = "status", required = false) ControleGuiaStatus status){
        List<ControleGuiaTuristicoEntity> controle = this.service.consultarByGuia(guiaId, status);
        return ResponseEntity.ok(controle);
    }

    @PostMapping("/guias/{guiaId}/agendamentos/{agendamentoId}/confirmar")
    public ResponseEntity confirmarAgendamento(@PathVariable("guiaId") Long guiaId, @PathVariable("agendamentoId") Long agendamentoId) {
        this.service.confirmarAgendamento(guiaId, agendamentoId);
        return ResponseEntity.ok().build();
    }
}