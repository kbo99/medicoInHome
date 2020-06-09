package com.medico.home.commons.farmacia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.medico.home.commons.servicio.model.DetalleServicioFarmacia;


/**
 * The persistent class for the faltante_detalle_farmacia database table.
 * 
 */
@Entity
@Table(name="faltante_detalle_farmacia")
@NamedQuery(name="FaltanteDetalleFarmacia.findAll", query="SELECT f FROM FaltanteDetalleFarmacia f")
public class FaltanteDetalleFarmacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fdf_id")
	private int fdfId;

	@Column(name="dsf_cantidad_faltante")
	private int dsfCantidadFaltante;

	@Column(name="dsf_estatus")
	private String dsfEstatus;

	@Temporal(TemporalType.DATE)
	@Column(name="dsf_fecha")
	private Date dsfFecha;

	//bi-directional many-to-one association to DetalleServicioFarmacia
	@ManyToOne
	@JoinColumn(name="dsf_id")
	private DetalleServicioFarmacia detalleServicioFarmacia;

	public FaltanteDetalleFarmacia() {
	}

	public int getFdfId() {
		return this.fdfId;
	}

	public void setFdfId(int fdfId) {
		this.fdfId = fdfId;
	}

	public int getDsfCantidadFaltante() {
		return this.dsfCantidadFaltante;
	}

	public void setDsfCantidadFaltante(int dsfCantidadFaltante) {
		this.dsfCantidadFaltante = dsfCantidadFaltante;
	}

	public String getDsfEstatus() {
		return this.dsfEstatus;
	}

	public void setDsfEstatus(String dsfEstatus) {
		this.dsfEstatus = dsfEstatus;
	}

	public Date getDsfFecha() {
		return this.dsfFecha;
	}

	public void setDsfFecha(Date dsfFecha) {
		this.dsfFecha = dsfFecha;
	}

	public DetalleServicioFarmacia getDetalleServicioFarmacia() {
		return this.detalleServicioFarmacia;
	}

	public void setDetalleServicioFarmacia(DetalleServicioFarmacia detalleServicioFarmacia) {
		this.detalleServicioFarmacia = detalleServicioFarmacia;
	}

}