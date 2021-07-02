package com.elianmelo.clinicaveterinaria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Anamnese implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O atributo problemaSistemaDigestivo deve ser preenchido.")
	private String problemaSistemaDigestivo;
	
	@NotNull(message = "O atributo problemaSistemaUroGenital deve ser preenchido.")
	private String problemaSistemaUroGenital;
	
	@NotNull(message = "O atributo problemaSistemaCardioRespiratorio deve ser preenchido.")
	private String problemaSistemaCardioRespiratorio;
	
	@NotNull(message = "O atributo problemaSistemaNeurologico deve ser preenchido.")
	private String problemaSistemaNeurologico;
	
	@NotNull(message = "O atributo problemaSistemaLocomotor deve ser preenchido.")
	private String problemaSistemaLocomotor;
	
	@NotNull(message = "O atributo problemaPele deve ser preenchido.")
	private String problemaPele;
	
	@NotNull(message = "O atributo problemaOlhos deve ser preenchido.")
	private String problemaOlhos;
	
	@NotNull(message = "O atributo problemaOuvido deve ser preenchido.")
	private String problemaOuvido;
	
    @OneToOne
	@JsonManagedReference(value="consultaAnamnese")
    @NotNull(message = "O atributo consulta deve ser preenchido.")
	private Consulta consulta;
	
	@ManyToMany
    private List<Doenca> doencas = new ArrayList<>();
	
	public Anamnese(String problemaSistemaDigestivo, String problemaSistemaUroGenital,
			String problemaSistemaCardioRespiratorio, String problemaSistemaNeurologico,
			String problemaSistemaLocomotor, String problemaPele, String problemaOlhos, String problemaOuvido, Consulta consulta) {
		super();
		this.problemaSistemaDigestivo = problemaSistemaDigestivo;
		this.problemaSistemaUroGenital = problemaSistemaUroGenital;
		this.problemaSistemaCardioRespiratorio = problemaSistemaCardioRespiratorio;
		this.problemaSistemaNeurologico = problemaSistemaNeurologico;
		this.problemaSistemaLocomotor = problemaSistemaLocomotor;
		this.problemaPele = problemaPele;
		this.problemaOlhos = problemaOlhos;
		this.problemaOuvido = problemaOuvido;
		this.consulta = consulta;
	}

}
