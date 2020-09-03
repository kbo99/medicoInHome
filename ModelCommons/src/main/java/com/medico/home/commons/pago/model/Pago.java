package com.medico.home.commons.pago.model;

import java.io.Serializable;
import javax.persistence.*;

import com.medico.home.commons.membresia.model.MembresiaCliente;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pag_id")
	private int pagId;

	@Column(name="cue_id")
	private int cueId;

	@Temporal(TemporalType.DATE)
	@Column(name="pag_fecha_limite")
	private Date pagFechaLimite;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pag_fecha_realizo")
	private Date pagFechaRealizo;

	@Column(name="pag_monto")
	private BigDecimal pagMonto;

	@Column(name="pag_observaciones")
	private String pagObservaciones;

	@Column(name="pag_referencia")
	private String pagReferencia;

	@Column(name="usu_registra")
	private String usuRegistra;

	//bi-directional many-to-one association to FormaPago
	@ManyToOne
	@JoinColumn(name="fpa_id")
	private FormaPago formaPago;

	//bi-directional many-to-one association to PagoEstatus
	@ManyToOne
	@JoinColumn(name="pgs_id")
	private PagoEstatus pagoEstatus;

	//bi-directional many-to-one association to TipoPago
	@ManyToOne
	@JoinColumn(name="tpp_id")
	private TipoPago tipoPago;
	
	@Transient
	private MembresiaCliente membresia;

	public Pago() {
	}

	public int getPagId() {
		return this.pagId;
	}

	public void setPagId(int pagId) {
		this.pagId = pagId;
	}

	public int getCueId() {
		return this.cueId;
	}

	public void setCueId(int cueId) {
		this.cueId = cueId;
	}

	public Date getPagFechaLimite() {
		return this.pagFechaLimite;
	}

	public void setPagFechaLimite(Date pagFechaLimite) {
		this.pagFechaLimite = pagFechaLimite;
	}

	public Date getPagFechaRealizo() {
		return this.pagFechaRealizo;
	}

	public void setPagFechaRealizo(Date pagFechaRealizo) {
		this.pagFechaRealizo = pagFechaRealizo;
	}

	public BigDecimal getPagMonto() {
		return this.pagMonto;
	}

	public void setPagMonto(BigDecimal pagMonto) {
		this.pagMonto = pagMonto;
	}

	public String getPagObservaciones() {
		return this.pagObservaciones;
	}

	public void setPagObservaciones(String pagObservaciones) {
		this.pagObservaciones = pagObservaciones;
	}

	public String getPagReferencia() {
		return this.pagReferencia;
	}

	public void setPagReferencia(String pagReferencia) {
		this.pagReferencia = pagReferencia;
	}

	public String getUsuRegistra() {
		return this.usuRegistra;
	}

	public void setUsuRegistra(String usuRegistra) {
		this.usuRegistra = usuRegistra;
	}

	public FormaPago getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public PagoEstatus getPagoEstatus() {
		return this.pagoEstatus;
	}

	public void setPagoEstatus(PagoEstatus pagoEstatus) {
		this.pagoEstatus = pagoEstatus;
	}

	public TipoPago getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	/**
	 * @return the membresia
	 */
	public MembresiaCliente getMembresia() {
		return membresia;
	}

	/**
	 * @param membresia the membresia to set
	 */
	public void setMembresia(MembresiaCliente membresia) {
		this.membresia = membresia;
	}

}