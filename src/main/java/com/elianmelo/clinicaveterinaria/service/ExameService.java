package com.elianmelo.clinicaveterinaria.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.elianmelo.clinicaveterinaria.domain.Exame;
import com.elianmelo.clinicaveterinaria.repository.ExameRepository;
import com.elianmelo.clinicaveterinaria.service.exception.ExameNaoEncontradoException;

@Service
public class ExameService {
	
	@Autowired
	ExameRepository repository;
	
	public List<Exame> todos() {
		return repository.findAll();
	}
	
	public Exame newExame(Exame exame) {
		return repository.save(exame);
	}
	
    public Exame exame(Integer id) throws Exception {
    	Optional<Exame> exame = repository.findById(id);
    	if(exame.isPresent()) {
    		return exame.get();
    	} else {
    		throw new ExameNaoEncontradoException(id);
    	}
    }
    
    public List<Exame> animalExame(Integer id) throws Exception {
    	List<Exame> exames = repository.findByAnimalExameId(id);
    	if(exames.size() == 0) {
    		throw new ExameNaoEncontradoException();
    	}
    	return exames;
    }

    public Exame atualiza(Exame exame, Integer id) {
    	exame.setId(id);
        return repository.save(exame);
	}

	public void deleteExame(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}

