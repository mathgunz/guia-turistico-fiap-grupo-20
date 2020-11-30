package com.controleguiaturistico.controllers;

import com.controleguiaturistico.controllers.dtos.AtracaoDTO;
import com.controleguiaturistico.controllers.dtos.RoteiroGuiaDTO;
import com.controleguiaturistico.repositories.entities.RoteiroAtracaoEntity;
import com.controleguiaturistico.repositories.entities.RoteiroEntity;
import com.controleguiaturistico.services.AtracaoService;
import com.controleguiaturistico.services.RoteiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class RoteiroController {

    private final RoteiroService service;
    private final AtracaoService atracaoService;

    public RoteiroController(RoteiroService service, AtracaoService atracaoService) {
        this.service = service;
        this.atracaoService = atracaoService;
    }

    @PostMapping("agendamentos/{agendamentoId}/roteiros")
    public ResponseEntity contratar(@PathVariable("agendamentoId") Long agendamentoId, @RequestBody RoteiroGuiaDTO roteiroGuiaDTO) {
        RoteiroEntity controleGuia = this.service.cadastrar(agendamentoId, roteiroGuiaDTO);
        return ResponseEntity.ok(controleGuia);
    }

    @GetMapping("agendamentos/{agendamentoId}/roteiros")
    public ResponseEntity consultar(@PathVariable("agendamentoId") Long agendamentoId){
        List<RoteiroEntity> roteiros = this.service.findAllByAgendamentoId(agendamentoId);
        return ResponseEntity.ok(roteiros);
    }

    @PostMapping("roteiros/{roteiroId}/atracoes")
    public ResponseEntity atracao(@PathVariable("roteiroId") Long roteiroId, @RequestBody AtracaoDTO atracaoDTO){
        RoteiroAtracaoEntity atracao = this.atracaoService.cadastrar(roteiroId, atracaoDTO);
        return ResponseEntity.ok(atracao);
    }

}