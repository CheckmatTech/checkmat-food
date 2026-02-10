package com.checkmattech.food.repository;

import com.checkmattech.food.domain.MovimentacaoEstoqueDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoqueDomain, Long>{}
