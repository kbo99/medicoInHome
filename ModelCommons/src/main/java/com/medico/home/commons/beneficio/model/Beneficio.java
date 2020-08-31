package com.medico.home.commons.beneficio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.medico.home.commons.membresia.model.MembresiaBeneficio;
import com.medico.home.commons.servicio.model.TipoServicio;


/**
 * The persistent class for the beneficio database table.
 * 
 */
@Entity
@NamedQuery(name="Beneficio.findAll", query="SELECT b FROM Beneficio b")
public class Beneficio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ben_id")
	private int benId;

	@Column(name="ben_descripcion")
	private String benDescripcion;

	@Column(name="ben_estatus")
	private String benEstatus;

	@Temporal(TemporalType.DATE)
	@Column(name="ben_fregistra")
	private Date benFregistra;

	@Column(name="ben_nombre")
	private String benNombre;

	@Column(name="usu_registra")
	private String usuRegistra;
	
	@Column(name="ben_cantidad_aplica")
	private int benCantidadAplica;

	@Column(name="ben_descuento")
	private int benDescuento;

	@Column(name="ben_periodo_renovacion_dias")
	private int benPeriodoRenovacionDias;

	@ManyToOne
	@JoinColumn(name="tps_id")
	private TipoServicio tipoServicio;

	
	public Beneficio() {
	}

	public int getBenId() {
		return this.benId;
	}

	public void setBenId(int benId) {
		this.benId = benId;
	}

	public String getBenDescripcion() {
		return this.benDescripcion;
	}

	public void setBenDescripcion(String benDescripcion) {
		this.benDescripcion = benDescripcion;
	}

	public String getBenEstatus() {
		return this.benEstatus;
	}

	public void setBenEstatus(String benEstatus) {
		this.benEstatus = benEstatus;
	}

	public Date getBenFregistra() {
		return this.benFregistra;
	}

	public void setBenFregistra(Date benFregistra) {
		this.benFregistra = benFregistra;
	}

	public String getBenNombre() {
		return this.benNombre;
	}

	public void setBenNombre(String benNombre) {
		this.benNombre = benNombre;
	}

	public String getUsuRegistra() {
		return this.usuRegistra;
	}

	public void setUsuRegistra(String usuRegistra) {
		this.usuRegistra = usuRegistra;
	}

	public int getBenCantidadAplica() {
		return benCantidadAplica;
	}

	public void setBenCantidadAplica(int benCantidadAplica) {
		this.benCantidadAplica = benCantidadAplica;
	}

	public int getBenDescuento() {
		return benDescuento;
	}

	public void setBenDescuento(int besDescuento) {
		this.benDescuento = besDescuento;
	}

	public int getBenPeriodoRenovacionDias() {
		return benPeriodoRenovacionDias;
	}

	public void setBenPeriodoRenovacionDias(int benPeriodoRenovacionDias) {
		this.benPeriodoRenovacionDias = benPeriodoRenovacionDias;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	


}