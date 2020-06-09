package com.medico.home.commons.cotizacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cotizacion database table.
 * 
 */
@Entity
@NamedQuery(name="Cotizacion.findAll", query="SELECT c FROM Cotizacion c")
public class Cotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cot_id")
	private int cotId;

	@Column(name="clien_id")
	private int clienId;

	@Column(name="cot_es_prospecto")
	private String cotEsProspecto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cot_fecha_registro")
	private Date cotFechaRegistro;

	@Column(name="cot_iva")
	private BigDecimal cotIva;

	@Column(name="cot_mail_prospecto")
	private String cotMailProspecto;

	@Column(name="cot_nombre_pros")
	private String cotNombrePros;

	@Column(name="cot_observacion")
	private String cotObservacion;

	@Column(name="cot_rfc_prospecto")
	private String cotRfcProspecto;

	@Column(name="cot_telefono_prospecto")
	private String cotTelefonoProspecto;

	@Column(name="cot_total")
	private BigDecimal cotTotal;

	@Column(name="usu_clave")
	private String usuClave;

	//bi-directional many-to-one association to CotizacionEstatus
	@ManyToOne
	@JoinColumn(name="ctesta_id")
	private CotizacionEstatus cotizacionEstatus;

	public Cotizacion() {
	}

	public int getCotId() {
		return this.cotId;
	}

	public void setCotId(int cotId) {
		this.cotId = cotId;
	}

	public int getClienId() {
		return this.clienId;
	}

	public void setClienId(int clienId) {
		this.clienId = clienId;
	}

	public String getCotEsProspecto() {
		return this.cotEsProspecto;
	}

	public void setCotEsProspecto(String cotEsProspecto) {
		this.cotEsProspecto = cotEsProspecto;
	}

	public Date getCotFechaRegistro() {
		return this.cotFechaRegistro;
	}

	public void setCotFechaRegistro(Date cotFechaRegistro) {
		this.cotFechaRegistro = cotFechaRegistro;
	}

	public BigDecimal getCotIva() {
		return this.cotIva;
	}

	public void setCotIva(BigDecimal cotIva) {
		this.cotIva = cotIva;
	}

	public String getCotMailProspecto() {
		return this.cotMailProspecto;
	}

	public void setCotMailProspecto(String cotMailProspecto) {
		this.cotMailProspecto = cotMailProspecto;
	}

	public String getCotNombrePros() {
		return this.cotNombrePros;
	}

	public void setCotNombrePros(String cotNombrePros) {
		this.cotNombrePros = cotNombrePros;
	}

	public String getCotObservacion() {
		return this.cotObservacion;
	}

	public void setCotObservacion(String cotObservacion) {
		this.cotObservacion = cotObservacion;
	}

	public String getCotRfcProspecto() {
		return this.cotRfcProspecto;
	}

	public void setCotRfcProspecto(String cotRfcProspecto) {
		this.cotRfcProspecto = cotRfcProspecto;
	}

	public String getCotTelefonoProspecto() {
		return this.cotTelefonoProspecto;
	}

	public void setCotTelefonoProspecto(String cotTelefonoProspecto) {
		this.cotTelefonoProspecto = cotTelefonoProspecto;
	}

	public BigDecimal getCotTotal() {
		return this.cotTotal;
	}

	public void setCotTotal(BigDecimal cotTotal) {
		this.cotTotal = cotTotal;
	}

	public String getUsuClave() {
		return this.usuClave;
	}

	public void setUsuClave(String usuClave) {
		this.usuClave = usuClave;
	}

	public CotizacionEstatus getCotizacionEstatus() {
		return this.cotizacionEstatus;
	}

	public void setCotizacionEstatus(CotizacionEstatus cotizacionEstatus) {
		this.cotizacionEstatus = cotizacionEstatus;
	}

}