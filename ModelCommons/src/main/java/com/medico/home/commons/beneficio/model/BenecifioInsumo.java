package com.medico.home.commons.beneficio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the benecifio_insumo database table.
 * 
 */
@Entity
@Table(name="benecifio_insumo")
@NamedQuery(name="BenecifioInsumo.findAll", query="SELECT b FROM BenecifioInsumo b")
public class BenecifioInsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bni_id")
	private int bniId;

	@Column(name="bes_id")
	private int besId;

	@Column(name="prod_id")
	private int prodId;

	public BenecifioInsumo() {
	}

	public int getBniId() {
		return this.bniId;
	}

	public void setBniId(int bniId) {
		this.bniId = bniId;
	}

	public int getBesId() {
		return this.besId;
	}

	public void setBesId(int besId) {
		this.besId = besId;
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

}