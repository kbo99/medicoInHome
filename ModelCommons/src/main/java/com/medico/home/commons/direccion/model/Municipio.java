package com.medico.home.commons.direccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mun_id")
	private int munId;

	@Column(name="cve_cab")
	private String cveCab;

	@Column(name="cve_mun")
	private String cveMun;

	@Column(name="mun_abr")
	private String munAbr;

	@Column(name="nom_cab")
	private String nomCab;

	@Column(name="nom_mun")
	private String nomMun;

	//bi-directional many-to-one association to Colonia
	@OneToMany(mappedBy="municipio")
	private List<Colonia> colonias;

	//bi-directional many-to-one association to Entidad
	@ManyToOne
	@JoinColumn(name="ent_id")
	private Entidad entidad;

	public Municipio() {
	}

	public int getMunId() {
		return this.munId;
	}

	public void setMunId(int munId) {
		this.munId = munId;
	}

	public String getCveCab() {
		return this.cveCab;
	}

	public void setCveCab(String cveCab) {
		this.cveCab = cveCab;
	}

	public String getCveMun() {
		return this.cveMun;
	}

	public void setCveMun(String cveMun) {
		this.cveMun = cveMun;
	}

	public String getMunAbr() {
		return this.munAbr;
	}

	public void setMunAbr(String munAbr) {
		this.munAbr = munAbr;
	}

	public String getNomCab() {
		return this.nomCab;
	}

	public void setNomCab(String nomCab) {
		this.nomCab = nomCab;
	}

	public String getNomMun() {
		return this.nomMun;
	}

	public void setNomMun(String nomMun) {
		this.nomMun = nomMun;
	}

	public List<Colonia> getColonias() {
		return this.colonias;
	}

	public void setColonias(List<Colonia> colonias) {
		this.colonias = colonias;
	}

	public Colonia addColonia(Colonia colonia) {
		getColonias().add(colonia);
		colonia.setMunicipio(this);

		return colonia;
	}

	public Colonia removeColonia(Colonia colonia) {
		getColonias().remove(colonia);
		colonia.setMunicipio(null);

		return colonia;
	}

	public Entidad getEntidad() {
		return this.entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

}