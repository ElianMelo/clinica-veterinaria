package com.elianmelo.clinicaveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elianmelo.clinicaveterinaria.domain.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer>{

}
