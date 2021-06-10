package com.elianmelo.clinicaveterinaria.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.elianmelo.clinicaveterinaria.domain.Exame;
import com.elianmelo.clinicaveterinaria.repository.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
	ExameRepository repository;
	
	public List<Exame> todos() {
		return repository.findAll();
	}
	
	public Exame novo(Exame exame) {
		return repository.save(exame);
	}
	
    public Exame exame(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Exame não encontrada"));
    }

    public Exame atualiza(Exame exame, Integer id) {
    	exame.setId(id);
        return repository.save(exame);
	}

	public void deleteExame(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}

