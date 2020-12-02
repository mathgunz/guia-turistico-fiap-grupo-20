package com.controleguiaturistico.services;

import com.controleguiaturistico.controllers.dtos.AtracaoDTO;
import com.controleguiaturistico.repositories.AtracaoRepository;
import com.controleguiaturistico.repositories.RoteiroRepository;
import com.controleguiaturistico.repositories.entities.RoteiroAtracaoEntity;
import com.controleguiaturistico.repositories.entities.RoteiroEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtracaoService {

    private final AtracaoRepository atracaoRepository;
    private final RoteiroRepository roteiroRepository;

    public AtracaoService(AtracaoRepository atracaoRepository, RoteiroRepository roteiroRepository) {
        this.atracaoRepository = atracaoRepository;
        this.roteiroRepository = roteiroRepository;
    }

    public RoteiroAtracaoEntity cadastrar(Long roteiroId, AtracaoDTO atracaoDTO) {

        Optional<RoteiroEntity> roteiroEntity = roteiroRepository.findById(roteiroId);

        RoteiroAtracaoEntity roteiroAtracaoEntity = new RoteiroAtracaoEntity();
        roteiroAtracaoEntity.setRoteiro(roteiroEntity.get());
        roteiroAtracaoEntity.setNome(atracaoDTO.getNome());
        roteiroAtracaoEntity.setAtracaoId(atracaoDTO.getAtracaoId());

        return this.atracaoRepository.save(roteiroAtracaoEntity);
    }

    public void deletar(Long roteiroId) {
        Optional<RoteiroEntity> roteiroEntity = roteiroRepository.findById(roteiroId);
        this.roteiroRepository.delete(roteiroEntity.get());
    }
}
