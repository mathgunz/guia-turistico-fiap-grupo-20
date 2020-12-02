package com.controleguiaturistico.services;

import com.controleguiaturistico.controllers.dtos.ControleGuiaDTO;
import com.controleguiaturistico.repositories.ControleGuiaTuristicoRepository;
import com.controleguiaturistico.repositories.entities.ClienteEntity;
import com.controleguiaturistico.repositories.entities.ControleGuiaStatus;
import com.controleguiaturistico.repositories.entities.ControleGuiaTuristicoEntity;
import com.controleguiaturistico.repositories.entities.GuiaEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ControleGuiaTuristicoService {

    private final ControleGuiaTuristicoRepository repository;

    public ControleGuiaTuristicoService(ControleGuiaTuristicoRepository repository) {
        this.repository = repository;
    }

    public ControleGuiaTuristicoEntity contratar(ControleGuiaDTO controleGuiaDTO) {

        ControleGuiaTuristicoEntity controleGuia = new ControleGuiaTuristicoEntity();
        controleGuia.setCliente(new ClienteEntity(controleGuiaDTO.getCliente()));
        controleGuia.setGuia(new GuiaEntity(controleGuiaDTO.getGuia()));
        controleGuia.setCheckin(controleGuiaDTO.getCheckin());
        controleGuia.setCheckout(controleGuiaDTO.getCheckout());
        controleGuia.setStatus(ControleGuiaStatus.AGUARDANDO_CONFIRMACAO_GUIA);
        controleGuia.setCriacao(new Date());

        return repository.save(controleGuia);
    }

    public List<ControleGuiaTuristicoEntity> consultarByGuia(Long guiaId, ControleGuiaStatus status) {


        List<ControleGuiaTuristicoEntity> agendamentos = this.repository.findAllByGuiaIdAndStatus(guiaId, status);

        return agendamentos;
    }

    public void confirmarAgendamento(Long guiaId, Long agendamentoId) {

        ControleGuiaTuristicoEntity entity = this.repository.findByIdAndGuiaId(agendamentoId, guiaId);

        entity.setStatus(ControleGuiaStatus.ATENDIMENTO_EM_ANDAMENTO);

        this.repository.save(entity);
    }

    public ControleGuiaTuristicoEntity findById(Long guiaId, Long agendamentoId) {
        ControleGuiaTuristicoEntity entity = this.repository.findByIdAndGuiaId(agendamentoId, guiaId);
        return entity;
    }
}
