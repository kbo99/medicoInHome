package com.medico.home.commons.pago.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_pago database table.
 * 
 */
@Entity
@Table(name="tipo_pago")
@NamedQuery(name="TipoPago.findAll", query="SELECT t FROM TipoPago t")
public class TipoPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tpp_id")
	private int tppId;

	@Column(name="tpp_desc")
	private String tppDesc;

	@Column(name="tpp_estatus")
	private String tppEstatus;

	@Column(name="tpp_genera_tarea")
	private String tppGeneraTarea;

	@Column(name="tpp_nombre")
	private String tppNombre;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="tipoPago")
	private List<Pago> pagos;

	public TipoPago() {
	}

	public int getTppId() {
		return this.tppId;
	}

	public void setTppId(int tppId) {
		this.tppId = tppId;
	}

	public String getTppDesc() {
		return this.tppDesc;
	}

	public void setTppDesc(String tppDesc) {
		this.tppDesc = tppDesc;
	}

	public String getTppEstatus() {
		return this.tppEstatus;
	}

	public void setTppEstatus(String tppEstatus) {
		this.tppEstatus = tppEstatus;
	}

	public String getTppGeneraTarea() {
		return this.tppGeneraTarea;
	}

	public void setTppGeneraTarea(String tppGeneraTarea) {
		this.tppGeneraTarea = tppGeneraTarea;
	}

	public String getTppNombre() {
		return this.tppNombre;
	}

	public void setTppNombre(String tppNombre) {
		this.tppNombre = tppNombre;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setTipoPago(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setTipoPago(null);

		return pago;
	}

}