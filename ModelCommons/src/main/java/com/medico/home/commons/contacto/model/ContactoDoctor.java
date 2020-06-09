package com.medico.home.commons.contacto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.medico.home.commons.doctor.model.Doctor;


/**
 * The persistent class for the contacto_doctor database table.
 * 
 */
@Entity
@Table(name="contacto_doctor")
@NamedQuery(name="ContactoDoctor.findAll", query="SELECT c FROM ContactoDoctor c")
public class ContactoDoctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_id")
	private int codId;

	//bi-directional many-to-one association to Contacto
	@ManyToOne
	@JoinColumn(name="ctn_id")
	private Contacto contacto;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="doc_id")
	private Doctor doctor;

	public ContactoDoctor() {
	}

	public int getCodId() {
		return this.codId;
	}

	public void setCodId(int codId) {
		this.codId = codId;
	}

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}