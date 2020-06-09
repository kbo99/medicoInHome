package com.medico.home.commons.producto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hproducto database table.
 * 
 */
@Entity
@NamedQuery(name="Hproducto.findAll", query="SELECT h FROM Hproducto h")
public class Hproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hps_id")
	private int hpsId;

	@Column(name="hps_cant_anterior")
	private int hpsCantAnterior;

	@Column(name="hps_cantidad_movimiento")
	private int hpsCantidadMovimiento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hps_fecha")
	private Date hpsFecha;

	@Column(name="prod_id")
	private int prodId;

	@Column(name="tmp_id")
	private int tmpId;

	private String usuario;

	public Hproducto() {
	}

	public int getHpsId() {
		return this.hpsId;
	}

	public void setHpsId(int hpsId) {
		this.hpsId = hpsId;
	}

	public int getHpsCantAnterior() {
		return this.hpsCantAnterior;
	}

	public void setHpsCantAnterior(int hpsCantAnterior) {
		this.hpsCantAnterior = hpsCantAnterior;
	}

	public int getHpsCantidadMovimiento() {
		return this.hpsCantidadMovimiento;
	}

	public void setHpsCantidadMovimiento(int hpsCantidadMovimiento) {
		this.hpsCantidadMovimiento = hpsCantidadMovimiento;
	}

	public Date getHpsFecha() {
		return this.hpsFecha;
	}

	public void setHpsFecha(Date hpsFecha) {
		this.hpsFecha = hpsFecha;
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getTmpId() {
		return this.tmpId;
	}

	public void setTmpId(int tmpId) {
		this.tmpId = tmpId;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}