package com.medico.home.commons.consulta.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medio_consulta database table.
 * 
 */
@Entity
@Table(name="medio_consulta")
@NamedQuery(name="MedioConsulta.findAll", query="SELECT m FROM MedioConsulta m")
public class MedioConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mec_id")
	private int mecId;

	@Column(name="mec_nombre")
	private String mecNombre;

	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="medioConsulta")
	private List<Consulta> consultas;

	public MedioConsulta() {
	}

	public int getMecId() {
		return this.mecId;
	}

	public void setMecId(int mecId) {
		this.mecId = mecId;
	}

	public String getMecNombre() {
		return this.mecNombre;
	}

	public void setMecNombre(String mecNombre) {
		this.mecNombre = mecNombre;
	}

	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta addConsulta(Consulta consulta) {
		getConsultas().add(consulta);
		consulta.setMedioConsulta(this);

		return consulta;
	}

	public Consulta removeConsulta(Consulta consulta) {
		getConsultas().remove(consulta);
		consulta.setMedioConsulta(null);

		return consulta;
	}

}