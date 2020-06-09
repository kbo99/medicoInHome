package com.medico.home.commons.consulta.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.medico.home.commons.servicio.model.Servicio;


/**
 * The persistent class for the servicio_consulta database table.
 * 
 */
@Entity
@Table(name="servicio_consulta")
@NamedQuery(name="ServicioConsulta.findAll", query="SELECT s FROM ServicioConsulta s")
public class ServicioConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="src_id")
	private int srcId;

	@Column(name="src_costo")
	private BigDecimal srcCosto;

	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="con_id")
	private Consulta consulta;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="ser_id")
	private Servicio servicio;

	public ServicioConsulta() {
	}

	public int getSrcId() {
		return this.srcId;
	}

	public void setSrcId(int srcId) {
		this.srcId = srcId;
	}

	public BigDecimal getSrcCosto() {
		return this.srcCosto;
	}

	public void setSrcCosto(BigDecimal srcCosto) {
		this.srcCosto = srcCosto;
	}

	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}