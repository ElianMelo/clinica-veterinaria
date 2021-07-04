package com.elianmelo.clinicaveterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elianmelo.clinicaveterinaria.domain.Anamnese;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese, Integer>{
	List<Anamnese> findByConsultaId(int id);
}
