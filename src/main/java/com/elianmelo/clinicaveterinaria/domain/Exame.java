package com.elianmelo.clinicaveterinaria.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Exame implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O atributo hemograma deve ser preenchido.")
	private Boolean hemograma;
	
	@NotNull(message = "O atributo colesterol deve ser preenchido.")
	private Boolean colesterol;
	
	@NotNull(message = "O atributo fosforo deve ser preenchido.")
	private Boolean fosforo;
	
	@NotNull(message = "O atributo calcio deve ser preenchido.")
	private Boolean calcio;
	
	@NotNull(message = "O atributo glicose deve ser preenchido.")
	private Boolean glicose;
	
	@NotNull(message = "O atributo magnesio deve ser preenchido.")
	private Boolean magnesio;
	
	@NotNull(message = "O atributo ureia deve ser preenchido.")
	private Boolean ureia;
	
	@NotNull(message = "O atributo potassio deve ser preenchido.")
	private Boolean potassio;
	
	@NotNull(message = "O atributo ultrassonografia deve ser preenchido.")
	private String ultrassonografia;
	
	@NotNull(message = "O atributo radiografia deve ser preenchido.")
	private String radiografia;
	
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "A data deve conter o formato aaaa-mm-dd")
	private String date;
	
	@ManyToOne
	@JsonManagedReference(value="animalExame")
	private Animal animalExame;
	
	public Exame(Boolean hemograma, Boolean colesterol, Boolean fosforo, Boolean calcio, Boolean glicose,
			Boolean magnesio, Boolean ureia, Boolean potassio, String ultrassonografia, String radiografia, String date, Animal animalExame) {
		super();
		this.hemograma = hemograma;
		this.colesterol = colesterol;
		this.fosforo = fosforo;
		this.calcio = calcio;
		this.glicose = glicose;
		this.magnesio = magnesio;
		this.ureia = ureia;
		this.potassio = potassio;
		this.ultrassonografia = ultrassonografia;
		this.radiografia = radiografia;
		this.date = date;
		this.animalExame = animalExame;
	}

}
