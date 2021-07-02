package com.elianmelo.clinicaveterinaria.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Doenca implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O atributo nome deve ser preenchido.")
	private String nome;
	
	public Doenca(String nome) {
		super();
		this.nome = nome;
	}
	
}
