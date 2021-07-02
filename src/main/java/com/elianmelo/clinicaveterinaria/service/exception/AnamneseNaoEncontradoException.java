package com.elianmelo.clinicaveterinaria.service.exception;

public class AnamneseNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AnamneseNaoEncontradoException(Integer id) {
		super("Anamnese não encontrado. ID " + id);
	}
}
