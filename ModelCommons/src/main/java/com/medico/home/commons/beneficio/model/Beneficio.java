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
	private int besDescuento;

	@Column(name="ben_periodo_renovacion_dias")
	private int ben_periodoRenovacionDias;

	@ManyToOne
	@JoinColumn(name="tps_id")
	private TipoServicio tipoServicio;

	//bi-directional many-to-one association to MembresiaBeneficio
	@OneToMany(mappedBy="beneficio")
	private List<MembresiaBeneficio> membresiaBeneficios;

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

	

	public List<MembresiaBeneficio> getMembresiaBeneficios() {
		return this.membresiaBeneficios;
	}

	public void setMembresiaBeneficios(List<MembresiaBeneficio> membresiaBeneficios) {
		this.membresiaBeneficios = membresiaBeneficios;
	}

	public MembresiaBeneficio addMembresiaBeneficio(MembresiaBeneficio membresiaBeneficio) {
		getMembresiaBeneficios().add(membresiaBeneficio);
		membresiaBeneficio.setBeneficio(this);

		return membresiaBeneficio;
	}

	public MembresiaBeneficio removeMembresiaBeneficio(MembresiaBeneficio membresiaBeneficio) {
		getMembresiaBeneficios().remove(membresiaBeneficio);
		membresiaBeneficio.setBeneficio(null);

		return membresiaBeneficio;
	}

}