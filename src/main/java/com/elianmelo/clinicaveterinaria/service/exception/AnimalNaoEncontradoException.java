package com.elianmelo.clinicaveterinaria.service.exception;

public class AnimalNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AnimalNaoEncontradoException(Integer id) {
		super("Animal não encontrado. ID " + id);
	}
}
