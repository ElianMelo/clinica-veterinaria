package com.elianmelo.clinicaveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elianmelo.clinicaveterinaria.domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{

}
