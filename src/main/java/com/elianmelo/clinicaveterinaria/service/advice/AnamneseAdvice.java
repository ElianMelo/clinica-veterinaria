package com.elianmelo.clinicaveterinaria.service.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.elianmelo.clinicaveterinaria.service.exception.AnamneseNaoEncontradoException;

@ControllerAdvice
public class AnamneseAdvice {
	@ResponseBody
	@ExceptionHandler(AnamneseNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String anamneseNaoEncontrado(AnamneseNaoEncontradoException ex) {
		return ex.getMessage();
	}
}
