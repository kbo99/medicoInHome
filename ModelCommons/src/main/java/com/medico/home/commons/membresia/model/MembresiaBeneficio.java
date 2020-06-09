package com.medico.home.commons.membresia.model;

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

import com.medico.home.commons.beneficio.model.Beneficio;


/**
 * The persistent class for the membresia_beneficio database table.
 * 
 */
@Entity
@Table(name="membresia_beneficio")
@NamedQuery(name="MembresiaBeneficio.findAll", query="SELECT m FROM MembresiaBeneficio m")
public class MembresiaBeneficio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="meb_id")
	private int mebId;

	@Column(name="meb_estatus")
	private String mebEstatus;

	//bi-directional many-to-one association to Beneficio
	@ManyToOne
	@JoinColumn(name="ben_id")
	private Beneficio beneficio;

	//bi-directional many-to-one association to Membresia
	@ManyToOne
	@JoinColumn(name="mem_id")
	private Membresia membresia;

	public MembresiaBeneficio() {
	}

	public int getMebId() {
		return this.mebId;
	}

	public void setMebId(int mebId) {
		this.mebId = mebId;
	}

	public String getMebEstatus() {
		return this.mebEstatus;
	}

	public void setMebEstatus(String mebEstatus) {
		this.mebEstatus = mebEstatus;
	}

	public Beneficio getBeneficio() {
		return this.beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public Membresia getMembresia() {
		return this.membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

}