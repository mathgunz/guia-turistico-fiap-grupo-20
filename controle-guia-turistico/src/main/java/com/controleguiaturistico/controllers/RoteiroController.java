package com.controleguiaturistico.controllers;

import com.controleguiaturistico.controllers.dtos.AtracaoDTO;
import com.controleguiaturistico.controllers.dtos.RoteiroGuiaDTO;
import com.controleguiaturistico.repositories.entities.RoteiroAtracaoEntity;
import com.controleguiaturistico.repositories.entities.RoteiroEntity;
import com.controleguiaturistico.services.AtracaoService;
import com.controleguiaturistico.services.RoteiroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@Api(tags = "Roteiros do Guia Turistico.")
public class RoteiroController {

    private final RoteiroService service;
    private final AtracaoService atracaoService;

    public RoteiroController(RoteiroService service, AtracaoService atracaoService) {
        this.service = service;
        this.atracaoService = atracaoService;
    }

    @ApiOperation(value = "Criar roteiros para atendimento do Guia.")
    @PostMapping("agendamentos/{agendamentoId}/roteiros")
    public ResponseEntity contratar(@PathVariable("agendamentoId") Long agendamentoId, @RequestBody RoteiroGuiaDTO roteiroGuiaDTO) {
        RoteiroEntity controleGuia = this.service.cadastrar(agendamentoId, roteiroGuiaDTO);
        return ResponseEntity.ok(controleGuia);
    }

    @ApiOperation(value = "Consultar roteiros de um Guia.")
    @GetMapping("agendamentos/{agendamentoId}/roteiros")
    public ResponseEntity consultar(@PathVariable("agendamentoId") Long agendamentoId){
        List<RoteiroEntity> roteiros = this.service.findAllByAgendamentoId(agendamentoId);
        return ResponseEntity.ok(roteiros);
    }

    @ApiOperation(value = "Definir atrações para um roteiro.")
    @PostMapping("agendamentos/{agendamentoId}/roteiros/{roteiroId}/atracoes")
    public ResponseEntity atracao(
            @PathVariable("agendamentoId") Long agendamentoId,
            @PathVariable("roteiroId") Long roteiroId, @RequestBody AtracaoDTO atracaoDTO){
        RoteiroAtracaoEntity atracao = this.atracaoService.cadastrar(roteiroId, atracaoDTO);
        return ResponseEntity.ok(atracao);
    }

    @ApiOperation(value = "Deletar roteiro.")
    @DeleteMapping("agendamentos/{agendamentoId}/roteiros/{roteiroId}")
    public ResponseEntity deletarRoteiro(
            @PathVariable("agendamentoId") Long agendamentoId,
            @PathVariable("roteiroId") Long roteiroId){
        this.atracaoService.deletar(roteiroId);
        return ResponseEntity.ok().build();
    }
}