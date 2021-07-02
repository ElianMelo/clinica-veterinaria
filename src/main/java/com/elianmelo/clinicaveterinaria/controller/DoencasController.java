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

import com.elianmelo.clinicaveterinaria.domain.Doenca;
import com.elianmelo.clinicaveterinaria.service.DoencaService;

@RestController
@RequestMapping("/doenca")
class DoencaController {

	@Autowired
	private DoencaService service;
	
	@GetMapping
	public List<Doenca> all() {
		return service.todos();
	}
	
	@PostMapping
	public ResponseEntity<String> newDoenca(@Valid @RequestBody Doenca doenca) {
		service.newDoenca(doenca);
		return ResponseEntity.ok("Doença cadastrada com sucesso."); 
	}
	
	@GetMapping("/{id}")
	public Doenca one(@PathVariable Integer id) throws Exception {
		return service.doenca(id);
	}
	
	@PutMapping("/{id}")
	public Doenca replaceDoenca(@RequestBody Doenca doenca, @PathVariable Integer id) {
		return service.atualiza(doenca, id);
	}
	
	@DeleteMapping("/{id}")
	void deleteDoenca(@PathVariable Integer id) {
		service.deleteDoenca(id);
	}
}