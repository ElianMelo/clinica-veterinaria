package com.elianmelo.clinicaveterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elianmelo.clinicaveterinaria.domain.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{
	
	List<Consulta> findByAnimalConsultaId(int id);
}
