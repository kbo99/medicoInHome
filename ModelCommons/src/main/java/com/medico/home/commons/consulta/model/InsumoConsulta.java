package com.medico.home.commons.consulta.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the insumo_consulta database table.
 * 
 */
@Entity
@Table(name="insumo_consulta")
@NamedQuery(name="InsumoConsulta.findAll", query="SELECT i FROM InsumoConsulta i")
public class InsumoConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inc_id")
	private int incId;

	@Column(name="con_id")
	private int conId;

	@Column(name="inc_cantidad")
	private int incCantidad;

	@Column(name="inc_costo_total")
	private BigDecimal incCostoTotal;

	@Column(name="inc_costo_unit")
	private BigDecimal incCostoUnit;

	@Column(name="prod_id")
	private int prodId;

	public InsumoConsulta() {
	}

	public int getIncId() {
		return this.incId;
	}

	public void setIncId(int incId) {
		this.incId = incId;
	}

	public int getConId() {
		return this.conId;
	}

	public void setConId(int conId) {
		this.conId = conId;
	}

	public int getIncCantidad() {
		return this.incCantidad;
	}

	public void setIncCantidad(int incCantidad) {
		this.incCantidad = incCantidad;
	}

	public BigDecimal getIncCostoTotal() {
		return this.incCostoTotal;
	}

	public void setIncCostoTotal(BigDecimal incCostoTotal) {
		this.incCostoTotal = incCostoTotal;
	}

	public BigDecimal getIncCostoUnit() {
		return this.incCostoUnit;
	}

	public void setIncCostoUnit(BigDecimal incCostoUnit) {
		this.incCostoUnit = incCostoUnit;
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

}