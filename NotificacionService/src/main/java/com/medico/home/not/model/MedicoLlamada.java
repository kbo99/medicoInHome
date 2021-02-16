package com.medico.home.not.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the medico_llamada database table.
 * 
 */
@Entity
@Table(name="medico_llamada")
@NamedQuery(name="MedicoLlamada.findAll", query="SELECT m FROM MedicoLlamada m")
public class MedicoLlamada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mll_id")
	private int mllId;

	@Column(name="llp_id")
	private int llpId;

	@Column(name="mll_estatus")
	private String mllEstatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mll_hora")
	private Date mllHora;

	@Column(name="mll_observaciones")
	private String mllObservaciones;

	@Column(name="user_medico")
	private String userMedico;

	public MedicoLlamada() {
	}

	public int getMllId() {
		return this.mllId;
	}

	public void setMllId(int mllId) {
		this.mllId = mllId;
	}

	public int getLlpId() {
		return this.llpId;
	}

	public void setLlpId(int llpId) {
		this.llpId = llpId;
	}

	public String getMllEstatus() {
		return this.mllEstatus;
	}

	public void setMllEstatus(String mllEstatus) {
		this.mllEstatus = mllEstatus;
	}

	public Date getMllHora() {
		return this.mllHora;
	}

	public void setMllHora(Date mllHora) {
		this.mllHora = mllHora;
	}

	public String getMllObservaciones() {
		return this.mllObservaciones;
	}

	public void setMllObservaciones(String mllObservaciones) {
		this.mllObservaciones = mllObservaciones;
	}

	public String getUserMedico() {
		return this.userMedico;
	}

	public void setUserMedico(String userMedico) {
		this.userMedico = userMedico;
	}

}