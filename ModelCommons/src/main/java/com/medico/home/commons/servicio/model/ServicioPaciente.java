package com.medico.home.commons.servicio.model;

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

import com.medico.home.commons.doctor.model.Paciente;


/**
 * The persistent class for the servicio_paciente database table.
 * 
 */
@Entity
@Table(name="servicio_paciente")
@NamedQuery(name="ServicioPaciente.findAll", query="SELECT s FROM ServicioPaciente s")
public class ServicioPaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="srp_id")
	private int srpId;

	@Column(name="srp_aplica_ben")
	private String srpAplicaBen;

	@Column(name="srp_costo")
	private BigDecimal srpCosto;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="pac_id")
	private Paciente paciente;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="ser_id")
	private Servicio servicio;

	public ServicioPaciente() {
	}

	public int getSrpId() {
		return this.srpId;
	}

	public void setSrpId(int srpId) {
		this.srpId = srpId;
	}

	public String getSrpAplicaBen() {
		return this.srpAplicaBen;
	}

	public void setSrpAplicaBen(String srpAplicaBen) {
		this.srpAplicaBen = srpAplicaBen;
	}

	public BigDecimal getSrpCosto() {
		return this.srpCosto;
	}

	public void setSrpCosto(BigDecimal srpCosto) {
		this.srpCosto = srpCosto;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}