package com.elianmelo.clinicaveterinaria.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.elianmelo.clinicaveterinaria.domain.Anamnese;
import com.elianmelo.clinicaveterinaria.repository.AnamneseRepository;
import com.elianmelo.clinicaveterinaria.service.exception.AnamneseNaoEncontradoException;

@Service
public class AnamneseService {
	
	@Autowired
	AnamneseRepository repository;
	
	public List<Anamnese> todos() {
		return repository.findAll();
	}
	
	public Anamnese newAnamnese(Anamnese anamnese) {
		Optional<Anamnese> anamneseBanco = repository.findById(anamnese.getConsulta().getId());
		if(anamneseBanco.isPresent()) {
			return repository.save(anamnese);
		} else {
			return atualiza(anamnese, anamneseBanco.get().getId());
		}
	}
	
    public Anamnese anamnese(Integer id) throws Exception {
    	Optional<Anamnese> anamnese = repository.findById(id);
    	if(anamnese.isPresent()) {
    		return anamnese.get();
    	} else {
    		throw new AnamneseNaoEncontradoException(id);
    	}  
    }
    
    public List<Anamnese> anamneseConsulta(Integer id) throws Exception {
    	List<Anamnese> anameneses = repository.findByConsultaId(id);
    	if(anameneses.size() == 0) {
    		throw new AnamneseNaoEncontradoException();
    	}
    	return anameneses;
    }

    public Anamnese atualiza(Anamnese anamnese, Integer id) {
    	anamnese.setId(id);
        return repository.save(anamnese);
	}

	public void deleteAnamnese(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}

