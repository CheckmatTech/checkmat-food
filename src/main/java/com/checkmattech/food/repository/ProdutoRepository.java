package com.checkmattech.food.repository;

import com.checkmattech.food.domain.ProdutoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoDomain, Long>{}
