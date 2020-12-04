package com.guia.services;

import com.guia.controllers.dtos.GuiaDTO;
import com.guia.repositories.GuiaRepository;
import com.guia.repositories.entities.GuiaEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class GuiaService {

    private final GuiaRepository repository;

    public GuiaService(GuiaRepository repository) {
        this.repository = repository;
    }

    public GuiaEntity criar(GuiaDTO guia) {
        GuiaEntity guiaEntity = new GuiaEntity(guia);
        return repository.save(guiaEntity);
    }

    public GuiaEntity buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public GuiaEntity update(Long id, GuiaDTO guia) {

        Optional<GuiaEntity> guiaEntityOptional = repository.findById(id);

        if (!guiaEntityOptional.isPresent()) return null;

        GuiaEntity guiaEntity = new GuiaEntity(guia);
        guiaEntity.setId(id);

        return repository.save(guiaEntity);
    }

    public boolean delete(Long id) {

        Optional<GuiaEntity> guiaEntityOptional = repository.findById(id);

        if (!guiaEntityOptional.isPresent()) return false;

        this.repository.delete(guiaEntityOptional.get());
        return true;
    }

    public List<GuiaEntity> buscarPorCidade(String nome){
    	
     	List<GuiaEntity> list = this.repository.findAllByEnderecoCidade(nome);

        return list;
    }
}
