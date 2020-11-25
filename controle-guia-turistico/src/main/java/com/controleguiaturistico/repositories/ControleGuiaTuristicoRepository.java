package com.controleguiaturistico.repositories;

import com.controleguiaturistico.repositories.entities.ControleGuiaTuristicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleGuiaTuristicoRepository extends JpaRepository<ControleGuiaTuristicoEntity, Long> {
}
