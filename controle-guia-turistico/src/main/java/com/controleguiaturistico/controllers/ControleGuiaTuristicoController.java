package com.controleguiaturistico.controllers;

import com.controleguiaturistico.controllers.dtos.ControleGuiaDTO;
import com.controleguiaturistico.repositories.entities.ControleGuiaStatus;
import com.controleguiaturistico.repositories.entities.ControleGuiaTuristicoEntity;
import com.controleguiaturistico.services.ControleGuiaTuristicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@Api(tags = "Contratação de atendimento de um Guia Turistico.")
public class ControleGuiaTuristicoController {

    private final ControleGuiaTuristicoService service;

    public ControleGuiaTuristicoController(ControleGuiaTuristicoService service) {
        this.service = service;
    }

    @ApiOperation(value = "Solicitar serviço de um Guia.")
    @PostMapping("agendamentos")
    public ResponseEntity contratar(@RequestBody ControleGuiaDTO controleGuiaDTO) {

        ControleGuiaTuristicoEntity controleGuia = this.service.contratar(controleGuiaDTO);

        return ResponseEntity.ok(controleGuia);
    }

    @ApiOperation(value = "Buscar atendimento do guia.")
    @GetMapping("/guias/{guiaId}/agendamentos/{agendamentoId}")
    public ResponseEntity buscarAgendamento(@PathVariable("guiaId") Long guiaId, @PathVariable("agendamentoId") Long agendamentoId) {

        ControleGuiaTuristicoEntity controleGuia = this.service.findById(guiaId, agendamentoId);

        return ResponseEntity.ok(controleGuia);
    }

    @ApiOperation(value = "Buscar atendimentos do guia.")
    @GetMapping("/guias/{guiaId}/agendamentos")
    public ResponseEntity consultar(@PathVariable("guiaId") Long guiaId,
                                    @RequestParam(value = "status", required = false) ControleGuiaStatus status){
        List<ControleGuiaTuristicoEntity> controle = this.service.consultarByGuia(guiaId, status);
        return ResponseEntity.ok(controle);
    }

    @ApiOperation(value = "Confirmar atendimento do cliente.")
    @PostMapping("/guias/{guiaId}/agendamentos/{agendamentoId}/confirmar")
    public ResponseEntity confirmarAgendamento(@PathVariable("guiaId") Long guiaId, @PathVariable("agendamentoId") Long agendamentoId) {
        this.service.confirmarAgendamento(guiaId, agendamentoId);
        return ResponseEntity.ok().build();
    }
}