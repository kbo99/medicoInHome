package com.medico.home.commons.producto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tpo_movimiento_producto database table.
 * 
 */
@Entity
@Table(name="tpo_movimiento_producto")
@NamedQuery(name="TpoMovimientoProducto.findAll", query="SELECT t FROM TpoMovimientoProducto t")
public class TpoMovimientoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tmp_id")
	private int tmpId;

	@Column(name="tmp_desc")
	private String tmpDesc;

	@Column(name="tmp_estatus")
	private String tmpEstatus;

	@Column(name="tmp_nombre")
	private String tmpNombre;

	@Column(name="tmp_suma")
	private String tmpSuma;

	public TpoMovimientoProducto() {
	}

	public int getTmpId() {
		return this.tmpId;
	}

	public void setTmpId(int tmpId) {
		this.tmpId = tmpId;
	}

	public String getTmpDesc() {
		return this.tmpDesc;
	}

	public void setTmpDesc(String tmpDesc) {
		this.tmpDesc = tmpDesc;
	}

	public String getTmpEstatus() {
		return this.tmpEstatus;
	}

	public void setTmpEstatus(String tmpEstatus) {
		this.tmpEstatus = tmpEstatus;
	}

	public String getTmpNombre() {
		return this.tmpNombre;
	}

	public void setTmpNombre(String tmpNombre) {
		this.tmpNombre = tmpNombre;
	}

	public String getTmpSuma() {
		return this.tmpSuma;
	}

	public void setTmpSuma(String tmpSuma) {
		this.tmpSuma = tmpSuma;
	}

}