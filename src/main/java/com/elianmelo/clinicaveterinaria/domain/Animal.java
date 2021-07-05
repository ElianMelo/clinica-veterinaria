package com.elianmelo.clinicaveterinaria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O atributo nome deve ser preenchido.")
	private String nome;
	
	@NotNull(message = "O atributo foto deve ser preenchido.")
	private String foto;
	
	@NotNull(message = "O atributo raca deve ser preenchido.")
	private String raca;
	
	@NotNull(message = "O atributo pelagem deve ser preenchido.")
	private String pelagem;
	
	@NotNull(message = "O atributo peso deve ser preenchido.")
	@Digits(integer= 3, fraction= 4, message = "Erro: Insira o valor de peso do animal entre 0 e 1000.")
	@Min(value = 0, message = "Erro: Insira um valor superior a 0.")
	private Double peso;
	
	@NotNull(message = "O atributo tipo deve ser preenchido.")
	@Min(value = 0, message = "Erro: Insira um valor superior a 0.")
	private int tipo;
	
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "A data deve conter o formato aaaa-mm-dd")
	private String dataNascimento;
	
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "A data deve conter o formato aaaa-mm-dd")
	private String dataCadastro;
	
	@NotNull(message = "O atributo estado deve ser preenchido.")
	private int estado;
	
	@OneToMany(mappedBy = "animalExame")
	@JsonBackReference(value="animalexame-ref")
	private List<Exame> exames = new ArrayList<Exame>();
	
	@OneToMany(mappedBy = "animalConsulta")
	@JsonBackReference(value="animalconsulta-ref")
	private List<Consulta> consultas = new ArrayList<Consulta>();
	
	public Animal(String nome, String foto, String raca, String pelagem, double peso, int tipo, String dataNascimento,
			String dataCadastro, int estado) {
		super();
		this.nome = nome;
		this.foto = foto;
		this.raca = raca;
		this.pelagem = pelagem;
		this.peso = peso;
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.estado = estado;
	}

}
