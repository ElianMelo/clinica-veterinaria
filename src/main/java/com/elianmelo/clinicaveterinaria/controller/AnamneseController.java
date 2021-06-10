package com.elianmelo.clinicaveterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elianmelo.clinicaveterinaria.domain.Anamnese;
import com.elianmelo.clinicaveterinaria.service.AnamneseService;

@RestController
@RequestMapping("/anamnese")
class AnamneseController {

	@Autowired
	private AnamneseService service;
	
	@GetMapping
	public List<Anamnese> all() {
		return service.todos();
	}
	
	@PostMapping
	public Anamnese novo(@RequestBody Anamnese anamnese) {
		return service.novo(anamnese);
	}
	
	@GetMapping("/{id}")
	public Anamnese one(@PathVariable Integer id) throws Exception {
		return service.anamnese(id);
	}
	
	@PutMapping("/{id}")
	public Anamnese replaceAnamnese(@RequestBody Anamnese anamnese, @PathVariable Integer id) {
		return service.atualiza(anamnese, id);
	}
	
	@DeleteMapping("/{id}")
	void deleteAnamnese(@PathVariable Integer id) {
		service.deleteAnamnese(id);
	}
}