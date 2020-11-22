package com.controleguiaturistico.repositories;

import com.controleguiaturistico.repositories.entities.RoteiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoteiroRepository extends JpaRepository<RoteiroEntity, Long> {
}
