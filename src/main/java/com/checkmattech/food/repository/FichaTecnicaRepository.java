package com.checkmattech.food.repository;

import com.checkmattech.food.domain.FichaTecnicaDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaTecnicaRepository extends JpaRepository<FichaTecnicaDomain, Long>{}
