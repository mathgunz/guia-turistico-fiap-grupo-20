package com.controleguiaturistico.services;

import com.controleguiaturistico.controllers.dtos.ControleGuiaDTO;
import com.controleguiaturistico.repositories.ControleGuiaTuristicoRepository;
import com.controleguiaturistico.repositories.entities.ClienteEntity;
import com.controleguiaturistico.repositories.entities.ControleGuiaStatus;
import com.controleguiaturistico.repositories.entities.ControleGuiaTuristicoEntity;
import com.controleguiaturistico.repositories.entities.GuiaEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
