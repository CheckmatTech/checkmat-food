package com.checkmattech.food.repository;

import com.checkmattech.food.domain.PratoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratoRepository extends JpaRepository<PratoDomain, Long>{}
