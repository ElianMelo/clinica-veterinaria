package com.elianmelo.clinicaveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elianmelo.clinicaveterinaria.domain.Doenca;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Integer>{

}
