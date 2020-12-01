package com.guia.repositories;

import com.guia.repositories.entities.AtracaoEntity;
import com.guia.repositories.entities.GuiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtracaoRepository extends JpaRepository<AtracaoEntity, Long> {
    List<AtracaoEntity> findAllByGuia(GuiaEntity guia);
}
