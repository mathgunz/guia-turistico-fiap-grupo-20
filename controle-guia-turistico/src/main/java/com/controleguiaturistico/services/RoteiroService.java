package com.controleguiaturistico.services;

import com.controleguiaturistico.controllers.dtos.RoteiroGuiaDTO;
import com.controleguiaturistico.repositories.ControleGuiaTuristicoRepository;
import com.controleguiaturistico.repositories.RoteiroRepository;
import com.controleguiaturistico.repositories.entities.ControleGuiaTuristicoEntity;
import com.controleguiaturistico.repositories.entities.RoteiroAtracaoEntity;
import com.controleguiaturistico.repositories.entities.RoteiroEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoteiroService {

    private final RoteiroRepository roteiroRepository;
    private final ControleGuiaTuristicoRepository controleGuiaTuristicoRepository;

    public RoteiroService(RoteiroRepository roteiroRepository, ControleGuiaTuristicoRepository controleGuiaTuristicoRepository) {
        this.roteiroRepository = roteiroRepository;
        this.controleGuiaTuristicoRepository = controleGuiaTuristicoRepository;
    }

    public RoteiroEntity cadastrar(Long agendamentoId, RoteiroGuiaDTO roteiroGuiaDTO) {

        Optional<ControleGuiaTuristicoEntity> controleEntity = this.controleGuiaTuristicoRepository.findById(agendamentoId);

        if (controleEntity.isEmpty()){
            return null;
        }

        RoteiroEntity roteiroEntity = new RoteiroEntity();
        roteiroEntity.setNome(roteiroGuiaDTO.getNome());
        roteiroEntity.setCriacao(new Date());
        roteiroEntity.setDescricao(roteiroGuiaDTO.getDescricao());
        roteiroEntity.setControle(controleEntity.get());

        this.roteiroRepository.save(roteiroEntity);

        if (roteiroGuiaDTO.getAtracoes() == null || roteiroGuiaDTO.getAtracoes().isEmpty()) return null;

        roteiroGuiaDTO.getAtracoes().forEach(atracaoDTO -> {
            RoteiroAtracaoEntity roteiroAtracaoEntity = new RoteiroAtracaoEntity();
            roteiroAtracaoEntity.setRoteiro(roteiroEntity);
            roteiroAtracaoEntity.setAtracaoId(atracaoDTO.getAtracaoId());
            roteiroAtracaoEntity.setNome(atracaoDTO.getNome());
        });
        return roteiroEntity;
    }

    public List<RoteiroEntity> findAllByAgendamentoId(Long agendamentoId) {

        List<RoteiroEntity> roteiros = this.roteiroRepository.findAllByControleId(agendamentoId);

        return roteiros;
    }
}
