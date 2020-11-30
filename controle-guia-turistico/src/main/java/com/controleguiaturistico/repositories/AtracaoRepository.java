package com.controleguiaturistico.repositories;

import com.controleguiaturistico.repositories.entities.RoteiroAtracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtracaoRepository extends JpaRepository<RoteiroAtracaoEntity, Long> {

}
