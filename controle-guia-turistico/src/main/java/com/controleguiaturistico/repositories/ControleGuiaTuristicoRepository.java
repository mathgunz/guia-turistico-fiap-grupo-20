package com.controleguiaturistico.repositories;

import com.controleguiaturistico.repositories.entities.ControleGuiaStatus;
import com.controleguiaturistico.repositories.entities.ControleGuiaTuristicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControleGuiaTuristicoRepository extends JpaRepository<ControleGuiaTuristicoEntity, Long> {

    @Query("from controleGuiaTuristico con where con.guia.id = :guiaId and (:status is null or con.status = :status)")
    List<ControleGuiaTuristicoEntity> findAllByGuiaIdAndStatus(@Param("guiaId") Long guiaId, @Param("status") ControleGuiaStatus status);
}