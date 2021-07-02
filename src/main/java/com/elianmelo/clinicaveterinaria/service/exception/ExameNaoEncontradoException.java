package com.elianmelo.clinicaveterinaria.service.exception;

public class ExameNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExameNaoEncontradoException(Integer id) {
		super("Exame não encontrado. ID " + id);
	}
	
	public ExameNaoEncontradoException() {
		super("Exame não encontrado");
	}
}
