package com.medico.home.commons.servicio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hservicio database table.
 * 
 */
@Entity
@NamedQuery(name="Hservicio.findAll", query="SELECT h FROM Hservicio h")
public class Hservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hse_id")
	private int hseId;

	@Column(name="hse_estatus_ser_new")
	private String hseEstatusSerNew;

	@Column(name="hse_estatus_ser_old")
	private String hseEstatusSerOld;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hse_hora_cambio_estatu")
	private Date hseHoraCambioEstatu;

	@Column(name="hse_observacion")
	private String hseObservacion;

	@Column(name="usu_reporta")
	private String usuReporta;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="ser_id")
	private Servicio servicio;

	public Hservicio() {
	}

	public int getHseId() {
		return this.hseId;
	}

	public void setHseId(int hseId) {
		this.hseId = hseId;
	}

	public String getHseEstatusSerNew() {
		return this.hseEstatusSerNew;
	}

	public void setHseEstatusSerNew(String hseEstatusSerNew) {
		this.hseEstatusSerNew = hseEstatusSerNew;
	}

	public String getHseEstatusSerOld() {
		return this.hseEstatusSerOld;
	}

	public void setHseEstatusSerOld(String hseEstatusSerOld) {
		this.hseEstatusSerOld = hseEstatusSerOld;
	}

	public Date getHseHoraCambioEstatu() {
		return this.hseHoraCambioEstatu;
	}

	public void setHseHoraCambioEstatu(Date hseHoraCambioEstatu) {
		this.hseHoraCambioEstatu = hseHoraCambioEstatu;
	}

	public String getHseObservacion() {
		return this.hseObservacion;
	}

	public void setHseObservacion(String hseObservacion) {
		this.hseObservacion = hseObservacion;
	}

	public String getUsuReporta() {
		return this.usuReporta;
	}

	public void setUsuReporta(String usuReporta) {
		this.usuReporta = usuReporta;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}