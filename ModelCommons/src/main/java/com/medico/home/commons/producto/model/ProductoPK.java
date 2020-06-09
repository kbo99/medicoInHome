package com.medico.home.commons.producto.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the producto database table.
 * 
 */
@Embeddable
public class ProductoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="prod_id")
	private int prodId;

	@Column(name="prod_nombre")
	private String prodNombre;

	@Temporal(TemporalType.DATE)
	@Column(name="prod_fecha_registro")
	private java.util.Date prodFechaRegistro;

	public ProductoPK() {
	}
	public int getProdId() {
		return this.prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdNombre() {
		return this.prodNombre;
	}
	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}
	public java.util.Date getProdFechaRegistro() {
		return this.prodFechaRegistro;
	}
	public void setProdFechaRegistro(java.util.Date prodFechaRegistro) {
		this.prodFechaRegistro = prodFechaRegistro;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductoPK)) {
			return false;
		}
		ProductoPK castOther = (ProductoPK)other;
		return 
			(this.prodId == castOther.prodId)
			&& this.prodNombre.equals(castOther.prodNombre)
			&& this.prodFechaRegistro.equals(castOther.prodFechaRegistro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.prodId;
		hash = hash * prime + this.prodNombre.hashCode();
		hash = hash * prime + this.prodFechaRegistro.hashCode();
		
		return hash;
	}
}