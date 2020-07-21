package com.medico.home.commons.producto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_producto database table.
 * 
 */
@Entity
@Table(name="tipo_producto")
@NamedQuery(name="TipoProducto.findAll", query="SELECT t FROM TipoProducto t")
public class TipoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tpoprod_id")
	private int tpoprodId;

	@Column(name="tpoprod_decrip")
	private String tpoprodDecrip;

	@Column(name="tpoprod_nombre")
	private String tpoprodNombre;

	@Column(name="tpoprod_estatus")
	private String tpoprodEstatus;
	

	public TipoProducto() {
	}

	public int getTpoprodId() {
		return this.tpoprodId;
	}

	public void setTpoprodId(int tpoprodId) {
		this.tpoprodId = tpoprodId;
	}

	public String getTpoprodDecrip() {
		return this.tpoprodDecrip;
	}

	public void setTpoprodDecrip(String tpoprodDecrip) {
		this.tpoprodDecrip = tpoprodDecrip;
	}

	public String getTpoprodNombre() {
		return this.tpoprodNombre;
	}

	public void setTpoprodNombre(String tpoprodNombre) {
		this.tpoprodNombre = tpoprodNombre;
	}

	/**
	 * @return the tpoprodEstatus
	 */
	public String getTpoprodEstatus() {
		return tpoprodEstatus;
	}

	/**
	 * @param tpoprodEstatus the tpoprodEstatus to set
	 */
	public void setTpoprodEstatus(String tpoprodEstatus) {
		this.tpoprodEstatus = tpoprodEstatus;
	}

	


}