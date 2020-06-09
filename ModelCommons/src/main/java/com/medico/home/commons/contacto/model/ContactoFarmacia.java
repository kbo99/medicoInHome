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

import com.medico.home.commons.farmacia.model.Farmacia;


/**
 * The persistent class for the contacto_farmacia database table.
 * 
 */
@Entity
@Table(name="contacto_farmacia")
@NamedQuery(name="ContactoFarmacia.findAll", query="SELECT c FROM ContactoFarmacia c")
public class ContactoFarmacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cof_id")
	private int cofId;

	@Column(name="cof_descp")
	private String cofDescp;

	@Column(name="ctn_nombre")
	private String ctnNombre;

	//bi-directional many-to-one association to Contacto
	@ManyToOne
	@JoinColumn(name="ctn_id")
	private Contacto contacto;

	//bi-directional many-to-one association to Farmacia
	@ManyToOne
	@JoinColumn(name="far_id")
	private Farmacia farmacia;

	
	public ContactoFarmacia() {
	}

	public int getCofId() {
		return this.cofId;
	}

	public void setCofId(int cofId) {
		this.cofId = cofId;
	}

	public String getCofDescp() {
		return this.cofDescp;
	}

	public void setCofDescp(String cofDescp) {
		this.cofDescp = cofDescp;
	}

	public String getCtnNombre() {
		return this.ctnNombre;
	}

	public void setCtnNombre(String ctnNombre) {
		this.ctnNombre = ctnNombre;
	}

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Farmacia getFarmacia() {
		return this.farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	
}