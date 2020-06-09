package com.medico.home.commons.consulta.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the diagnostico_consulta database table.
 * 
 */
@Entity
@Table(name="diagnostico_consulta")
@NamedQuery(name="DiagnosticoConsulta.findAll", query="SELECT d FROM DiagnosticoConsulta d")
public class DiagnosticoConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dic_id")
	private int dicId;

	@Column(name="dic_observacion")
	private String dicObservacion;

	@Column(name="dic_sintomas")
	private String dicSintomas;

	@Column(name="enf_id")
	private int enfId;

	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="con_id")
	private Consulta consulta;

	public DiagnosticoConsulta() {
	}

	public int getDicId() {
		return this.dicId;
	}

	public void setDicId(int dicId) {
		this.dicId = dicId;
	}

	public String getDicObservacion() {
		return this.dicObservacion;
	}

	public void setDicObservacion(String dicObservacion) {
		this.dicObservacion = dicObservacion;
	}

	public String getDicSintomas() {
		return this.dicSintomas;
	}

	public void setDicSintomas(String dicSintomas) {
		this.dicSintomas = dicSintomas;
	}

	public int getEnfId() {
		return this.enfId;
	}

	public void setEnfId(int enfId) {
		this.enfId = enfId;
	}

	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}