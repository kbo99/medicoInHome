package com.medico.home.commons.doctor.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especialidad database table.
 * 
 */
@Entity
@NamedQuery(name="Especialidad.findAll", query="SELECT e FROM Especialidad e")
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="esp_id")
	private int espId;

	@Column(name="esp_desc")
	private String espDesc;

	@Column(name="esp_nombre")
	private String espNombre;

	//bi-directional many-to-one association to Enfermedad
	@OneToMany(mappedBy="especialidad")
	private List<Enfermedad> enfermedads;

	//bi-directional many-to-many association to Doctor
	@ManyToMany
	@JoinTable(
		name="doc_especial"
		, joinColumns={
			@JoinColumn(name="esp_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="doc_id")
			}
		)
	private List<Doctor> doctors;

	public Especialidad() {
	}

	public int getEspId() {
		return this.espId;
	}

	public void setEspId(int espId) {
		this.espId = espId;
	}

	public String getEspDesc() {
		return this.espDesc;
	}

	public void setEspDesc(String espDesc) {
		this.espDesc = espDesc;
	}

	public String getEspNombre() {
		return this.espNombre;
	}

	public void setEspNombre(String espNombre) {
		this.espNombre = espNombre;
	}

	public List<Enfermedad> getEnfermedads() {
		return this.enfermedads;
	}

	public void setEnfermedads(List<Enfermedad> enfermedads) {
		this.enfermedads = enfermedads;
	}

	public Enfermedad addEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().add(enfermedad);
		enfermedad.setEspecialidad(this);

		return enfermedad;
	}

	public Enfermedad removeEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().remove(enfermedad);
		enfermedad.setEspecialidad(null);

		return enfermedad;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}