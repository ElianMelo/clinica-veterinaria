package com.elianmelo.clinicaveterinaria.service.exception;

public class ConsultaNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConsultaNaoEncontradoException(Integer id) {
		super("Consulta não encontrada. ID " + id);
	}
	
	public ConsultaNaoEncontradoException() {
		super("Consulta não encontrada");
	}
}
