package com.medico.home.commons.doctor.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enfermedad database table.
 * 
 */
@Entity
@NamedQuery(name="Enfermedad.findAll", query="SELECT e FROM Enfermedad e")
public class Enfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enf_id")
	private int enfId;

	@Column(name="enf_cronica")
	private String enfCronica;

	@Column(name="enf_desc")
	private String enfDesc;

	@Column(name="enf_nombre")
	private String enfNombre;

	//bi-directional many-to-one association to Especialidad
	@ManyToOne
	@JoinColumn(name="esp_id")
	private Especialidad especialidad;

	//bi-directional many-to-one association to TipoEnfermedad
	@ManyToOne
	@JoinColumn(name="ten_id")
	private TipoEnfermedad tipoEnfermedad;

	public Enfermedad() {
	}

	public int getEnfId() {
		return this.enfId;
	}

	public void setEnfId(int enfId) {
		this.enfId = enfId;
	}

	public String getEnfCronica() {
		return this.enfCronica;
	}

	public void setEnfCronica(String enfCronica) {
		this.enfCronica = enfCronica;
	}

	public String getEnfDesc() {
		return this.enfDesc;
	}

	public void setEnfDesc(String enfDesc) {
		this.enfDesc = enfDesc;
	}

	public String getEnfNombre() {
		return this.enfNombre;
	}

	public void setEnfNombre(String enfNombre) {
		this.enfNombre = enfNombre;
	}

	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public TipoEnfermedad getTipoEnfermedad() {
		return this.tipoEnfermedad;
	}

	public void setTipoEnfermedad(TipoEnfermedad tipoEnfermedad) {
		this.tipoEnfermedad = tipoEnfermedad;
	}

}