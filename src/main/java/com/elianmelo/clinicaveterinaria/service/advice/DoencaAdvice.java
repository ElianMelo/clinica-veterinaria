package com.elianmelo.clinicaveterinaria.service.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.elianmelo.clinicaveterinaria.service.exception.DoencaNaoEncontradoException;

@ControllerAdvice
public class DoencaAdvice {
	@ResponseBody
	@ExceptionHandler(DoencaNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String doencaNaoEncontrado(DoencaNaoEncontradoException ex) {
		return ex.getMessage();
	}
}
