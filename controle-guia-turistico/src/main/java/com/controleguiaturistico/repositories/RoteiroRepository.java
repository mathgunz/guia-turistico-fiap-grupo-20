package com.controleguiaturistico.repositories;

import com.controleguiaturistico.repositories.entities.RoteiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoteiroRepository extends JpaRepository<RoteiroEntity, Long> {

    List<RoteiroEntity> findAllByControleId(@Param("agendamentoId") Long agendamentoId);
}
