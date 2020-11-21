package com.controleguiaturistico.repositories;

import com.controleguiaturistico.repositories.entities.ContratacaoGuiaTuristicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratacaoGuiaTuristicoRepository extends JpaRepository<ContratacaoGuiaTuristicoEntity, Long> {
}
