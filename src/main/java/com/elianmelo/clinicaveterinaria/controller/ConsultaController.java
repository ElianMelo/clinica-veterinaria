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

import com.elianmelo.clinicaveterinaria.domain.Consulta;
import com.elianmelo.clinicaveterinaria.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
class ConsultaController {

	@Autowired
	private ConsultaService service;
	
	@GetMapping
	public List<Consulta> all() {
		return service.todos();
	}
	
	@PostMapping
	public ResponseEntity<String> newConsulta(@Valid @RequestBody Consulta consulta) {
		service.newConsulta(consulta);
		return ResponseEntity.ok("Consulta cadastrada com sucesso."); 
	}
	
	@GetMapping("/{id}")
	public Consulta one(@PathVariable Integer id) throws Exception {
		return service.consulta(id);
	}
	
	@GetMapping("/id={id}")
	public List<Consulta> animal(@PathVariable Integer id) throws Exception {
		return service.animalConsulta(id);
	}
	
	@PutMapping("/{id}")
	public Consulta replaceConsulta(@RequestBody Consulta consulta, @PathVariable Integer id) {
		return service.atualiza(consulta, id);
	}
	
	@DeleteMapping("/{id}")
	void deleteConsulta(@PathVariable Integer id) {
		service.deleteConsulta(id);
	}
}