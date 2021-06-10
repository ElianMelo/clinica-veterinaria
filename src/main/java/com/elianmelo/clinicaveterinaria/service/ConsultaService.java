package com.elianmelo.clinicaveterinaria.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.elianmelo.clinicaveterinaria.domain.Consulta;
import com.elianmelo.clinicaveterinaria.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	ConsultaRepository repository;
	
	public List<Consulta> todos() {
		return repository.findAll();
	}
	
	public Consulta novo(Consulta consulta) {
		return repository.save(consulta);
	}
	
    public Consulta consulta(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Consulta não encontrada"));
    }

    public Consulta atualiza(Consulta consulta, Integer id) {
    	consulta.setId(id);
        return repository.save(consulta);
	}

	public void deleteConsulta(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}

