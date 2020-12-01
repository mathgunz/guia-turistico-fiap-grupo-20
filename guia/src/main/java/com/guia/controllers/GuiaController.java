package com.guia.controllers;

import com.guia.controllers.dtos.AtracaoDTO;
import com.guia.controllers.dtos.GuiaDTO;
import com.guia.repositories.entities.AtracaoEntity;
import com.guia.repositories.entities.GuiaEntity;
import com.guia.services.AtracaoService;
import com.guia.services.GuiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/guias")
@RestController
public class GuiaController {

    private final GuiaService service;
    private final AtracaoService atracaoService;

    public GuiaController(GuiaService service, AtracaoService atracaoService) {
        this.service = service;
        this.atracaoService = atracaoService;
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody GuiaDTO guia) {

        GuiaEntity guiaEntity = service.criar(guia);

        return ResponseEntity.ok(guiaEntity);
    }

    @GetMapping("{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id){

        GuiaEntity guiaEntity = service.buscarPorId(id);

        return ResponseEntity.ok(guiaEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity criar(@PathVariable("id") Long id, @RequestBody GuiaDTO guia) {

        GuiaEntity guiaEntity = service.update(id, guia);

        return ResponseEntity.ok(guiaEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id, @RequestBody GuiaDTO guia) {

        boolean hasGuia = service.delete(id);

        return hasGuia ? ResponseEntity.notFound().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("{id}/atracoes")
    public ResponseEntity criarAtracao(@PathVariable("id") Long id, @RequestBody AtracaoDTO atracaoDTO){

        GuiaEntity guia = this.service.buscarPorId(id);

        if (guia == null) ResponseEntity.notFound().build();

        AtracaoEntity atracaoEntity = this.atracaoService.criarAtracao(guia, atracaoDTO);

        return ResponseEntity.ok(atracaoEntity);
    }

    @GetMapping("{id}/atracoes")
    public ResponseEntity listarAtracoes(@PathVariable("id") Long guiaId){

        GuiaEntity guia = this.service.buscarPorId(guiaId);
        if (guia == null) ResponseEntity.notFound().build();

        List<AtracaoEntity> atracoes = atracaoService.listarPorGuiaId(guia);

        return atracoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atracoes);
    }

    @PutMapping("{guiaId}/atracoes/{atracaoId}")
    public ResponseEntity alterarAtracao(
            @PathVariable("guiaId") Long guiaId,
            @PathVariable("atracaoId") Long atracaoId,
            @RequestBody AtracaoDTO AtracaoDTO){

        AtracaoEntity atracaoEntity = this.atracaoService.findById(atracaoId);
        if (atracaoEntity == null) ResponseEntity.notFound().build();

        AtracaoEntity atracaoEntityNovo = atracaoService.alterarAtracao(atracaoEntity, AtracaoDTO);
        return ResponseEntity.ok(atracaoEntityNovo);
    }

    @DeleteMapping("{id}/atracoes/{atracaoId}")
    public ResponseEntity deletarAtracao(@PathVariable("id") Long guiaId,
                                         @PathVariable("atracaoId") Long atracaoId){
        AtracaoEntity atracaoEntity = this.atracaoService.findById(atracaoId);
        if (atracaoEntity == null) ResponseEntity.notFound().build();
        this.atracaoService.delete(atracaoEntity);
        return ResponseEntity.noContent().build();
    };

}