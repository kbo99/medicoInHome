package com.medico.home.commons.membresia.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medico.home.commons.beneficio.model.Beneficio;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the membresia database table.
 * 
 */
@Entity
@NamedQuery(name="Membresia.findAll", query="SELECT m FROM Membresia m")
public class Membresia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mem_id")
	private int memId;

	@Column(name="mem_descripcion")
	private String memDescripcion;

	@Column(name="mem_estatus")
	private String memEstatus;

	@Temporal(TemporalType.DATE)
	@Column(name="mem_fcreacion")
	private Date memFcreacion;

	@Column(name="mem_nombre")
	private String memNombre;

	@Column(name="mem_vigencia_meses")
	private int memVigenciaMeses;

	@Column(name="usu_registra")
	private String usuRegistra;

	//bi-directional many-to-one association to MembresiaBeneficio
	@OneToMany(mappedBy="membresia")

	private List<MembresiaBeneficio> membresiaBeneficios;

	
	
	@Column(name="mem_costo")
	private Integer memCosto;

	@Column(name="mem_costo_ben_ad")
	private Integer memCostoBenAd;

	@Column(name="mem_numero_bene")
	private Integer memNumeroBene;
    
	@Transient
	private List<Beneficio> beneficios;

	public Membresia() {
	}

	public int getMemId() {
		return this.memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public String getMemDescripcion() {
		return this.memDescripcion;
	}

	public void setMemDescripcion(String memDescripcion) {
		this.memDescripcion = memDescripcion;
	}

	public String getMemEstatus() {
		return this.memEstatus;
	}

	public void setMemEstatus(String memEstatus) {
		this.memEstatus = memEstatus;
	}

	public Date getMemFcreacion() {
		return this.memFcreacion;
	}

	public void setMemFcreacion(Date memFcreacion) {
		this.memFcreacion = memFcreacion;
	}

	public String getMemNombre() {
		return this.memNombre;
	}

	public void setMemNombre(String memNombre) {
		this.memNombre = memNombre;
	}

	public int getMemVigenciaMeses() {
		return this.memVigenciaMeses;
	}

	public void setMemVigenciaMeses(int memVigenciaMeses) {
		this.memVigenciaMeses = memVigenciaMeses;
	}

	public String getUsuRegistra() {
		return this.usuRegistra;
	}

	public void setUsuRegistra(String usuRegistra) {
		this.usuRegistra = usuRegistra;
	}

	@JsonIgnore
	public List<MembresiaBeneficio> getMembresiaBeneficios() {
		return this.membresiaBeneficios;
	}

	public void setMembresiaBeneficios(List<MembresiaBeneficio> membresiaBeneficios) {
		this.membresiaBeneficios = membresiaBeneficios;
	}

	public MembresiaBeneficio addMembresiaBeneficio(MembresiaBeneficio membresiaBeneficio) {
		getMembresiaBeneficios().add(membresiaBeneficio);
		membresiaBeneficio.setMembresia(this);

		return membresiaBeneficio;
	}

	public MembresiaBeneficio removeMembresiaBeneficio(MembresiaBeneficio membresiaBeneficio) {
		getMembresiaBeneficios().remove(membresiaBeneficio);
		membresiaBeneficio.setMembresia(null);

		return membresiaBeneficio;
	}



	public Integer getMemCosto() {
		return memCosto;
	}

	public void setMemCosto(Integer memCosto) {
		this.memCosto = memCosto;
	}

	public Integer getMemCostoBenAd() {
		return memCostoBenAd;
	}

	public void setMemCostoBenAd(Integer memCostoBenAd) {
		this.memCostoBenAd = memCostoBenAd;
	}

	public Integer getMemNumeroBene() {
		return memNumeroBene;
	}

	public void setMemNumeroBene(Integer memNumeroBene) {
		this.memNumeroBene = memNumeroBene;
	}

	public List<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

}