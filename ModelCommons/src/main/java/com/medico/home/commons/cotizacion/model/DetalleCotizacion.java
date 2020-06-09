package com.medico.home.commons.cotizacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_cotizacion database table.
 * 
 */
@Entity
@Table(name="detalle_cotizacion")
@NamedQuery(name="DetalleCotizacion.findAll", query="SELECT d FROM DetalleCotizacion d")
public class DetalleCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dtc_id")
	private int dtcId;

	@Column(name="cot_id")
	private int cotId;

	@Column(name="dtc_cantidad")
	private int dtcCantidad;

	@Column(name="dtc_descuento")
	private BigDecimal dtcDescuento;

	@Column(name="dtc_iva")
	private BigDecimal dtcIva;

	@Column(name="dtc_monto")
	private BigDecimal dtcMonto;

	@Column(name="dtc_monto_desc")
	private BigDecimal dtcMontoDesc;

	@Column(name="pro_id")
	private int proId;

	public DetalleCotizacion() {
	}

	public int getDtcId() {
		return this.dtcId;
	}

	public void setDtcId(int dtcId) {
		this.dtcId = dtcId;
	}

	public int getCotId() {
		return this.cotId;
	}

	public void setCotId(int cotId) {
		this.cotId = cotId;
	}

	public int getDtcCantidad() {
		return this.dtcCantidad;
	}

	public void setDtcCantidad(int dtcCantidad) {
		this.dtcCantidad = dtcCantidad;
	}

	public BigDecimal getDtcDescuento() {
		return this.dtcDescuento;
	}

	public void setDtcDescuento(BigDecimal dtcDescuento) {
		this.dtcDescuento = dtcDescuento;
	}

	public BigDecimal getDtcIva() {
		return this.dtcIva;
	}

	public void setDtcIva(BigDecimal dtcIva) {
		this.dtcIva = dtcIva;
	}

	public BigDecimal getDtcMonto() {
		return this.dtcMonto;
	}

	public void setDtcMonto(BigDecimal dtcMonto) {
		this.dtcMonto = dtcMonto;
	}

	public BigDecimal getDtcMontoDesc() {
		return this.dtcMontoDesc;
	}

	public void setDtcMontoDesc(BigDecimal dtcMontoDesc) {
		this.dtcMontoDesc = dtcMontoDesc;
	}

	public int getProId() {
		return this.proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

}