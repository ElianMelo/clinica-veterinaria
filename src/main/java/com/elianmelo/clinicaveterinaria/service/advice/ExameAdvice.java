package com.elianmelo.clinicaveterinaria.service.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.elianmelo.clinicaveterinaria.service.exception.ExameNaoEncontradoException;

@ControllerAdvice
public class ExameAdvice {
	@ResponseBody
	@ExceptionHandler(ExameNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String exameNaoEncontrado(ExameNaoEncontradoException ex) {
		return ex.getMessage();
	}
}
