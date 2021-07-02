package com.elianmelo.clinicaveterinaria.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "A data deve conter o formato aaaa-mm-dd")
	private String date;
	
	@NotNull(message = "O atributo observacoes deve ser preenchido.")
	private String observacoes;
	
	@NotNull(message = "O atributo queixa deve ser preenchido.")
	private String queixa;
	
	@NotNull(message = "O atributo historico deve ser preenchido.")
	private String historico;
	
	@ManyToOne
	@JsonManagedReference(value="animalConsulta")
	private Animal animalConsulta;
	
    @OneToOne(mappedBy = "consulta")
	@JsonBackReference(value="consultaAnamnese")
    private Anamnese anamnese;
	
	public Consulta(String date, String observacoes, String queixa, String historico, Animal animalConsulta) {
		super();
		this.date = date;
		this.observacoes = observacoes;
		this.queixa = queixa;
		this.historico = historico;
		this.animalConsulta = animalConsulta;
	}
	
}
