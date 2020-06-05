package com.medico.home.commons.persona.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="per_id")
	private int perId;

	@Column(name="per_ape_mat")
	private String perApeMat;

	@Column(name="per_ape_pate")
	private String perApePate;

	@Column(name="per_email")
	private String perEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="per_falta")
	private Date perFalta;

	@Column(name="per_nombre")
	private String perNombre;

	public Persona() {
	}

	public int getPerId() {
		return this.perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public String getPerApeMat() {
		return this.perApeMat;
	}

	public void setPerApeMat(String perApeMat) {
		this.perApeMat = perApeMat;
	}

	public String getPerApePate() {
		return this.perApePate;
	}

	public void setPerApePate(String perApePate) {
		this.perApePate = perApePate;
	}

	public String getPerEmail() {
		return this.perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public Date getPerFalta() {
		return this.perFalta;
	}

	public void setPerFalta(Date perFalta) {
		this.perFalta = perFalta;
	}

	public String getPerNombre() {
		return this.perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	

}