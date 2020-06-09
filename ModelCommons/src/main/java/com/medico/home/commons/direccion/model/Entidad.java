package com.medico.home.commons.direccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the entidad database table.
 * 
 */
@Entity
@NamedQuery(name="Entidad.findAll", query="SELECT e FROM Entidad e")
public class Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ent_id")
	private String entId;

	@Column(name="ent_abr")
	private String entAbr;

	@Column(name="ent_nom")
	private String entNom;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="pai_id")
	private Pai pai;

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="entidad")
	private List<Municipio> municipios;

	public Entidad() {
	}

	public String getEntId() {
		return this.entId;
	}

	public void setEntId(String entId) {
		this.entId = entId;
	}

	public String getEntAbr() {
		return this.entAbr;
	}

	public void setEntAbr(String entAbr) {
		this.entAbr = entAbr;
	}

	public String getEntNom() {
		return this.entNom;
	}

	public void setEntNom(String entNom) {
		this.entNom = entNom;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

	public List<Municipio> getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public Municipio addMunicipio(Municipio municipio) {
		getMunicipios().add(municipio);
		municipio.setEntidad(this);

		return municipio;
	}

	public Municipio removeMunicipio(Municipio municipio) {
		getMunicipios().remove(municipio);
		municipio.setEntidad(null);

		return municipio;
	}

}