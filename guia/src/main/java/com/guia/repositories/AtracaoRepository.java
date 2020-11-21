package com.guia.repositories;

import com.guia.repositories.entities.AtracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtracaoRepository extends JpaRepository<AtracaoEntity, Long> {
}
