package com.medico.home.commons.beneficio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.medico.home.commons.servicio.model.TipoServicio;


/**
 * The persistent class for the beneficio_servicio database table.
 * 
 */
@Entity
@Table(name="beneficio_servicio")
@NamedQuery(name="BeneficioServicio.findAll", query="SELECT b FROM BeneficioServicio b")
public class BeneficioServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bns_id")
	private int bnsId;

	@ManyToOne
	@JoinColumn(name="tps_id")
	private TipoServicio tipoServicio;

	//bi-directional many-to-one association to BeneficioDetalle
	@ManyToOne
	@JoinColumn(name="bes_id")
	private BeneficioDetalle beneficioDetalle;

	public BeneficioServicio() {
	}

	public int getBnsId() {
		return this.bnsId;
	}

	public void setBnsId(int bnsId) {
		this.bnsId = bnsId;
	}

	

	public BeneficioDetalle getBeneficioDetalle() {
		return this.beneficioDetalle;
	}

	public void setBeneficioDetalle(BeneficioDetalle beneficioDetalle) {
		this.beneficioDetalle = beneficioDetalle;
	}

	/**
	 * @return the tipoServicio
	 */
	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	/**
	 * @param tipoServicio the tipoServicio to set
	 */
	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

}