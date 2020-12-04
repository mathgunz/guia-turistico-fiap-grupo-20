package com.guia.repositories;

import com.guia.repositories.entities.GuiaEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuiaRepository extends JpaRepository<GuiaEntity, Long> {

	 List<GuiaEntity> findAllByEnderecoCidade(String nome);
}
