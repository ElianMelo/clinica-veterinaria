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

import com.elianmelo.clinicaveterinaria.domain.Exame;
import com.elianmelo.clinicaveterinaria.service.ExameService;

@RestController
@RequestMapping("/exame")
class ExameController {

	@Autowired
	private ExameService service;
	
	@GetMapping
	public List<Exame> all() {
		return service.todos();
	}
	
	@PostMapping
	public Exame novo(@RequestBody Exame exame) {
		return service.novo(exame);
	}
	
	@GetMapping("/{id}")
	public Exame one(@PathVariable Integer id) throws Exception {
		return service.exame(id);
	}
	
	@PutMapping("/{id}")
	public Exame replaceExame(@RequestBody Exame exame, @PathVariable Integer id) {
		return service.atualiza(exame, id);
	}
	
	@DeleteMapping("/{id}")
	void deleteExame(@PathVariable Integer id) {
		service.deleteExame(id);
	}
}