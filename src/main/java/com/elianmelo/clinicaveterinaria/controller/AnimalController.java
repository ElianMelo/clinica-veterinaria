package com.elianmelo.clinicaveterinaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elianmelo.clinicaveterinaria.domain.Animal;
import com.elianmelo.clinicaveterinaria.service.AnimalService;

@RestController
@RequestMapping("/animal")
class AnimalController {

	@Autowired
	private AnimalService service;
	
	@GetMapping
	public List<Animal> all() {
		return service.todos();
	}
	
	@PostMapping
	public ResponseEntity<String> newAnimal(@Valid @RequestBody Animal animal) {
		service.newAnimal(animal);
		return ResponseEntity.ok("Animal cadastrado com sucesso."); 
	}
	
	@GetMapping("/{id}")
	public Animal one(@PathVariable Integer id) throws Exception {
		return service.animal(id);
	}
	
	@PutMapping("/{id}")
	public Animal replaceAnimal(@RequestBody Animal animal, @PathVariable Integer id) {
		return service.atualiza(animal, id);
	}
	
	@DeleteMapping("/{id}")
	void deleteAnimal(@PathVariable Integer id) {
		service.deleteAnimal(id);
	}
}