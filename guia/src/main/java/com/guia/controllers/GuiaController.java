package com.guia.controllers;

import com.guia.controllers.dtos.AtracaoDTO;
import com.guia.controllers.dtos.GuiaDTO;
import com.guia.repositories.entities.AtracaoEntity;
import com.guia.repositories.entities.GuiaEntity;
import com.guia.services.AtracaoService;
import com.guia.services.GuiaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/guias")
@RestController
@Api(tags = "Guias turisticos")
public class GuiaController {

    private final GuiaService service;
    private final AtracaoService atracaoService;

    public GuiaController(GuiaService service, AtracaoService atracaoService) {
        this.service = service;
        this.atracaoService = atracaoService;
    }

    @ApiOperation(value = "Cadastrar guias turisticos",
            notes = "Operação utilizada para cadastrar um guia")
    @PostMapping
    public ResponseEntity criar(@RequestBody GuiaDTO guia) {

        GuiaEntity guiaEntity = service.criar(guia);

        return ResponseEntity.ok(guiaEntity);
    }

    @ApiOperation(value = "Buscar por id do guia"
            , notes = "Operação para buscar um guia por id")
    @GetMapping("{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id){

        GuiaEntity guiaEntity = service.buscarPorId(id);

        return ResponseEntity.ok(guiaEntity);
    }

    @ApiOperation(value = "Buscar guias por cidade"
            , notes = "Operação para buscar guias por cidade")
    @GetMapping
    public ResponseEntity buscarPorCidade(@RequestParam("cidade") String cidade){

        List<GuiaEntity> guiaEntity = service.buscarPorCidade(cidade);

        return ResponseEntity.ok(guiaEntity);
    }

    @ApiOperation(value = "Atualizar informações do guia"
            , notes = "Operação para atualizar informações do guia por id")
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody GuiaDTO guia) {

        GuiaEntity guiaEntity = service.update(id, guia);

        return ResponseEntity.ok(guiaEntity);
    }
    @ApiOperation(value = "Deletar informações do guia"
            , notes = "Operação para deletar informações do guia por id")
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id, @RequestBody GuiaDTO guia) {

        boolean hasGuia = service.delete(id);

        return hasGuia ? ResponseEntity.notFound().build() : ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Criar atração turistica de um guia"
            , notes = "Operação utilizada para o guia cadastrar uma atração turistica")
    @PostMapping("{id}/atracoes")
    public ResponseEntity criarAtracao(@PathVariable("id") Long id, @RequestBody AtracaoDTO atracaoDTO){

        GuiaEntity guia = this.service.buscarPorId(id);

        if (guia == null) ResponseEntity.notFound().build();

        AtracaoEntity atracaoEntity = this.atracaoService.criarAtracao(guia, atracaoDTO);

        return ResponseEntity.ok(atracaoEntity);
    }

    @ApiOperation(value = "Listar atrações turisticas de um guia"
            , notes = "Operação utilizada listar todas as atrações de um guia")
    @GetMapping("{id}/atracoes")
    public ResponseEntity listarAtracoes(@PathVariable("id") Long guiaId){

        GuiaEntity guia = this.service.buscarPorId(guiaId);
        if (guia == null) ResponseEntity.notFound().build();

        List<AtracaoEntity> atracoes = atracaoService.listarPorGuiaId(guia);

        return atracoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atracoes);
    }

    @ApiOperation(value = "Alterar atrações turisticas de um guia"
            , notes = "Operação utilizada o guia alterar uma determinada atração")
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

    @ApiOperation(value = "Deletar atração turisticas de um guia"
            , notes = "Operação utilizada o guia deletar uma atração que não faz parte do roteiro")
    @DeleteMapping("{id}/atracoes/{atracaoId}")
    public ResponseEntity deletarAtracao(@PathVariable("id") Long guiaId,
                                         @PathVariable("atracaoId") Long atracaoId){
        AtracaoEntity atracaoEntity = this.atracaoService.findById(atracaoId);
        if (atracaoEntity == null) ResponseEntity.notFound().build();
        this.atracaoService.delete(atracaoEntity);
        return ResponseEntity.noContent().build();
    };

}