package com.medico.home.commons.beneficio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the beneficio_detalle database table.
 * 
 */
@Entity
@Table(name="beneficio_detalle")
@NamedQuery(name="BeneficioDetalle.findAll", query="SELECT b FROM BeneficioDetalle b")
public class BeneficioDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bes_id")
	private int besId;

	@Column(name="bes_aplica_descuento")
	private String besAplicaDescuento;

	@Column(name="bes_cantidad_aplica")
	private int besCantidadAplica;

	@Column(name="bes_descuento")
	private int besDescuento;

	@Column(name="bes_periodo_renovacion_dias")
	private int besPeriodoRenovacionDias;

	//bi-directional many-to-one association to Beneficio
	@ManyToOne
	@JoinColumn(name="ben_id")
	private Beneficio beneficio;

	//bi-directional many-to-one association to BeneficioServicio
	@OneToMany(mappedBy="beneficioDetalle")
	private List<BeneficioServicio> beneficioServicios;

	public BeneficioDetalle() {
	}

	public int getBesId() {
		return this.besId;
	}

	public void setBesId(int besId) {
		this.besId = besId;
	}

	public String getBesAplicaDescuento() {
		return this.besAplicaDescuento;
	}

	public void setBesAplicaDescuento(String besAplicaDescuento) {
		this.besAplicaDescuento = besAplicaDescuento;
	}

	public int getBesCantidadAplica() {
		return this.besCantidadAplica;
	}

	public void setBesCantidadAplica(int besCantidadAplica) {
		this.besCantidadAplica = besCantidadAplica;
	}

	public int getBesDescuento() {
		return this.besDescuento;
	}

	public void setBesDescuento(int besDescuento) {
		this.besDescuento = besDescuento;
	}

	public int getBesPeriodoRenovacionDias() {
		return this.besPeriodoRenovacionDias;
	}

	public void setBesPeriodoRenovacionDias(int besPeriodoRenovacionDias) {
		this.besPeriodoRenovacionDias = besPeriodoRenovacionDias;
	}

	public Beneficio getBeneficio() {
		return this.beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public List<BeneficioServicio> getBeneficioServicios() {
		return this.beneficioServicios;
	}

	public void setBeneficioServicios(List<BeneficioServicio> beneficioServicios) {
		this.beneficioServicios = beneficioServicios;
	}

	public BeneficioServicio addBeneficioServicio(BeneficioServicio beneficioServicio) {
		getBeneficioServicios().add(beneficioServicio);
		beneficioServicio.setBeneficioDetalle(this);

		return beneficioServicio;
	}

	public BeneficioServicio removeBeneficioServicio(BeneficioServicio beneficioServicio) {
		getBeneficioServicios().remove(beneficioServicio);
		beneficioServicio.setBeneficioDetalle(null);

		return beneficioServicio;
	}

}