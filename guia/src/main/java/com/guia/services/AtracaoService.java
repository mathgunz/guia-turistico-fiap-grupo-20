package com.guia.services;

import com.guia.controllers.dtos.AtracaoDTO;
import com.guia.repositories.AtracaoRepository;
import com.guia.repositories.entities.AtracaoEntity;
import com.guia.repositories.entities.GuiaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtracaoService {

    private final AtracaoRepository atracaoRepository;

    public AtracaoService(AtracaoRepository atracaoRepository) {
        this.atracaoRepository = atracaoRepository;
    }

    public AtracaoEntity criarAtracao(GuiaEntity guia, AtracaoDTO atracaoDTO) {

        AtracaoEntity atracaoEntity = new AtracaoEntity(guia, atracaoDTO);

        return atracaoEntity;
    }

    public List<AtracaoEntity> listarPorGuiaId(GuiaEntity guia) {
        return atracaoRepository.findAllByGuia(guia);
    }

    public AtracaoEntity findById(Long atracaoId) {
        return atracaoRepository.findById(atracaoId).get();

    }

    public AtracaoEntity alterarAtracao(AtracaoEntity atracaoEntity, AtracaoDTO atracaoDTO) {
        AtracaoEntity atracaoEntityNovo = new AtracaoEntity(atracaoEntity.getGuia(), atracaoDTO);
        atracaoEntityNovo.setId(atracaoEntity.getId());
        return atracaoRepository.save(atracaoEntityNovo);
    }

    public void delete(AtracaoEntity atracaoEntity) {
        atracaoRepository.delete(atracaoEntity);
    }
}
