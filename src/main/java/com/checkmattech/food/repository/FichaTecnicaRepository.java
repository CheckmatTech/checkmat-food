package com.checkmattech.food.repository;

import com.checkmattech.food.domain.FichaTecnicaDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaTecnicaRepository extends JpaRepository<FichaTecnicaDomain, Long>{
    List<FichaTecnicaDomain> findByPratoId(Long pratoID);
}
