package com.elianmelo.clinicaveterinaria.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.elianmelo.clinicaveterinaria.domain.Animal;
import com.elianmelo.clinicaveterinaria.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	AnimalRepository repository;
	
	public List<Animal> todos() {
		return repository.findAll();
	}
	
	public Animal novo(Animal animal) {
		return repository.save(animal);
	}
	
    public Animal animal(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Animal não encontrada"));
    }

    public Animal atualiza(Animal animal, Integer id) {
    	animal.setId(id);
        return repository.save(animal);
	}

	public void deleteAnimal(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}

