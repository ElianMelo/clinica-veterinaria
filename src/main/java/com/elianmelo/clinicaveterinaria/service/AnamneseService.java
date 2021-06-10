package com.elianmelo.clinicaveterinaria.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.elianmelo.clinicaveterinaria.domain.Anamnese;
import com.elianmelo.clinicaveterinaria.repository.AnamneseRepository;

@Service
public class AnamneseService {
	
	@Autowired
	AnamneseRepository repository;
	
	public List<Anamnese> todos() {
		return repository.findAll();
	}
	
	public Anamnese novo(Anamnese anamnese) {
		return repository.save(anamnese);
	}
	
    public Anamnese anamnese(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Anamnese não encontrada"));
    }

    public Anamnese atualiza(Anamnese anamnese, Integer id) {
    	anamnese.setId(id);
        return repository.save(anamnese);
	}

	public void deleteAnamnese(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}

