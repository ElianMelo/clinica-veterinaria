package com.elianmelo.clinicaveterinaria.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.elianmelo.clinicaveterinaria.domain.Doenca;
import com.elianmelo.clinicaveterinaria.repository.DoencaRepository;
import com.elianmelo.clinicaveterinaria.service.exception.DoencaNaoEncontradoException;

@Service
public class DoencaService {
	
	@Autowired
	DoencaRepository repository;
	
	public List<Doenca> todos() {
		return repository.findAll();
	}
	
	public Doenca newDoenca(Doenca doenca) {
		return repository.save(doenca);
	}
	
    public Doenca doenca(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new DoencaNaoEncontradoException(id));
    }

    public Doenca atualiza(Doenca doenca, Integer id) {
    	doenca.setId(id);
        return repository.save(doenca);
	}

	public void deleteDoenca(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}

