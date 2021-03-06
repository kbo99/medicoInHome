package com.medico.home.commons.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	

	@Column(name="prm_descrp")
	private String prmDescrp;

	@Id
	@Column(name="prm_nombre")
	private String prmNombre;

	@Column(name="prm_valor")
	private String prmValor;

	public Parametro() {
	}

	
	public String getPrmDescrp() {
		return this.prmDescrp;
	}

	public void setPrmDescrp(String prmDescrp) {
		this.prmDescrp = prmDescrp;
	}

	public String getPrmNombre() {
		return this.prmNombre;
	}

	public void setPrmNombre(String prmNombre) {
		this.prmNombre = prmNombre;
	}

	public String getPrmValor() {
		return this.prmValor;
	}

	public void setPrmValor(String prmValor) {
		this.prmValor = prmValor;
	}

}