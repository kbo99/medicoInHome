package com.medico.home.commons.pago.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pago_estatus database table.
 * 
 */
@Entity
@Table(name="pago_estatus")
@NamedQuery(name="PagoEstatus.findAll", query="SELECT p FROM PagoEstatus p")
public class PagoEstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pgs_id")
	private int pgsId;

	@Column(name="pgs_default")
	private String pgsDefault;

	@Column(name="pgs_estatus")
	private String pgsEstatus;

	@Column(name="pgs_nombre")
	private String pgsNombre;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="pagoEstatus")
	private List<Pago> pagos;

	public PagoEstatus() {
	}

	public int getPgsId() {
		return this.pgsId;
	}

	public void setPgsId(int pgsId) {
		this.pgsId = pgsId;
	}

	public String getPgsDefault() {
		return this.pgsDefault;
	}

	public void setPgsDefault(String pgsDefault) {
		this.pgsDefault = pgsDefault;
	}

	public String getPgsEstatus() {
		return this.pgsEstatus;
	}

	public void setPgsEstatus(String pgsEstatus) {
		this.pgsEstatus = pgsEstatus;
	}

	public String getPgsNombre() {
		return this.pgsNombre;
	}

	public void setPgsNombre(String pgsNombre) {
		this.pgsNombre = pgsNombre;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setPagoEstatus(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setPagoEstatus(null);

		return pago;
	}

}