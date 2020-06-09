package com.medico.home.commons.pago.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the forma_pago database table.
 * 
 */
@Entity
@Table(name="forma_pago")
@NamedQuery(name="FormaPago.findAll", query="SELECT f FROM FormaPago f")
public class FormaPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fpa_id")
	private int fpaId;

	@Column(name="fpa_descrp")
	private String fpaDescrp;

	@Column(name="fpa_estatus")
	private String fpaEstatus;

	@Column(name="fpa_nombre")
	private String fpaNombre;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="formaPago")
	private List<Pago> pagos;

	public FormaPago() {
	}

	public int getFpaId() {
		return this.fpaId;
	}

	public void setFpaId(int fpaId) {
		this.fpaId = fpaId;
	}

	public String getFpaDescrp() {
		return this.fpaDescrp;
	}

	public void setFpaDescrp(String fpaDescrp) {
		this.fpaDescrp = fpaDescrp;
	}

	public String getFpaEstatus() {
		return this.fpaEstatus;
	}

	public void setFpaEstatus(String fpaEstatus) {
		this.fpaEstatus = fpaEstatus;
	}

	public String getFpaNombre() {
		return this.fpaNombre;
	}

	public void setFpaNombre(String fpaNombre) {
		this.fpaNombre = fpaNombre;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setFormaPago(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setFormaPago(null);

		return pago;
	}

}