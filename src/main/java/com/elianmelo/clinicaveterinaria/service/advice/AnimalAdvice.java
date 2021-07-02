package com.elianmelo.clinicaveterinaria.service.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.elianmelo.clinicaveterinaria.service.exception.AnimalNaoEncontradoException;

@ControllerAdvice
public class AnimalAdvice {
	@ResponseBody
	@ExceptionHandler(AnimalNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String animalNaoEncontrado(AnimalNaoEncontradoException ex) {
		return ex.getMessage();
	}
}
