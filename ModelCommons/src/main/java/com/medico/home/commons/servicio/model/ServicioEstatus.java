package com.medico.home.commons.servicio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicio_estatus database table.
 * 
 */
@Entity
@Table(name="servicio_estatus")
@NamedQuery(name="ServicioEstatus.findAll", query="SELECT s FROM ServicioEstatus s")
public class ServicioEstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ses_id")
	private int sesId;

	@Column(name="ses_desc")
	private String sesDesc;

	@Column(name="ses_estatus")
	private String sesEstatus;

	@Column(name="ses_nombre")
	private String sesNombre;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="servicioEstatus")
	private List<Servicio> servicios;

	public ServicioEstatus() {
	}

	public int getSesId() {
		return this.sesId;
	}

	public void setSesId(int sesId) {
		this.sesId = sesId;
	}

	public String getSesDesc() {
		return this.sesDesc;
	}

	public void setSesDesc(String sesDesc) {
		this.sesDesc = sesDesc;
	}

	public String getSesEstatus() {
		return this.sesEstatus;
	}

	public void setSesEstatus(String sesEstatus) {
		this.sesEstatus = sesEstatus;
	}

	public String getSesNombre() {
		return this.sesNombre;
	}

	public void setSesNombre(String sesNombre) {
		this.sesNombre = sesNombre;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setServicioEstatus(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setServicioEstatus(null);

		return servicio;
	}

}