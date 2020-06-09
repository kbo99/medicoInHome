package com.medico.home.commons.consulta.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the consulta_estatus database table.
 * 
 */
@Entity
@Table(name="consulta_estatus")
@NamedQuery(name="ConsultaEstatus.findAll", query="SELECT c FROM ConsultaEstatus c")
public class ConsultaEstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="coe_id")
	private int coeId;

	@Column(name="coe_nombre")
	private String coeNombre;

	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="consultaEstatus")
	private List<Consulta> consultas;

	public ConsultaEstatus() {
	}

	public int getCoeId() {
		return this.coeId;
	}

	public void setCoeId(int coeId) {
		this.coeId = coeId;
	}

	public String getCoeNombre() {
		return this.coeNombre;
	}

	public void setCoeNombre(String coeNombre) {
		this.coeNombre = coeNombre;
	}

	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta addConsulta(Consulta consulta) {
		getConsultas().add(consulta);
		consulta.setConsultaEstatus(this);

		return consulta;
	}

	public Consulta removeConsulta(Consulta consulta) {
		getConsultas().remove(consulta);
		consulta.setConsultaEstatus(null);

		return consulta;
	}

}