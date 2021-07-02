package com.elianmelo.clinicaveterinaria.service.exception;

public class DoencaNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DoencaNaoEncontradoException(Integer id) {
		super("Doenca não encontrado. ID " + id);
	}
}
