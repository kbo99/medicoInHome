package com.medico.home.commons.membresia.model;

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

import com.medico.home.commons.beneficio.model.TipoMovimientoBene;


/**
 * The persistent class for the movimiento_beneficio_mem database table.
 * 
 */
@Entity
@Table(name="movimiento_beneficio_mem")
@NamedQuery(name="MovimientoBeneficioMem.findAll", query="SELECT m FROM MovimientoBeneficioMem m")
public class MovimientoBeneficioMem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mbm_id")
	private int mbmId;

	@Column(name="mbm_cantidad_antes")
	private int mbmCantidadAntes;

	@Column(name="mbm_cantidad_mov")
	private int mbmCantidadMov;

	@Column(name="mbm_cantidad_nueva")
	private int mbmCantidadNueva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mbm_fecha_mod")
	private Date mbmFechaMod;

	@Column(name="usu_mov")
	private String usuMov;

	//bi-directional many-to-one association to MembresiaCliente
	@ManyToOne
	@JoinColumn(name="mec_id")
	private MembresiaCliente membresiaCliente;

	//bi-directional many-to-one association to TipoMovimientoBene
	@ManyToOne
	@JoinColumn(name="tmb_id")
	private TipoMovimientoBene tipoMovimientoBene;

	public MovimientoBeneficioMem() {
	}

	public int getMbmId() {
		return this.mbmId;
	}

	public void setMbmId(int mbmId) {
		this.mbmId = mbmId;
	}

	public int getMbmCantidadAntes() {
		return this.mbmCantidadAntes;
	}

	public void setMbmCantidadAntes(int mbmCantidadAntes) {
		this.mbmCantidadAntes = mbmCantidadAntes;
	}

	public int getMbmCantidadMov() {
		return this.mbmCantidadMov;
	}

	public void setMbmCantidadMov(int mbmCantidadMov) {
		this.mbmCantidadMov = mbmCantidadMov;
	}

	public int getMbmCantidadNueva() {
		return this.mbmCantidadNueva;
	}

	public void setMbmCantidadNueva(int mbmCantidadNueva) {
		this.mbmCantidadNueva = mbmCantidadNueva;
	}

	public Date getMbmFechaMod() {
		return this.mbmFechaMod;
	}

	public void setMbmFechaMod(Date mbmFechaMod) {
		this.mbmFechaMod = mbmFechaMod;
	}

	public String getUsuMov() {
		return this.usuMov;
	}

	public void setUsuMov(String usuMov) {
		this.usuMov = usuMov;
	}

	public MembresiaCliente getMembresiaCliente() {
		return this.membresiaCliente;
	}

	public void setMembresiaCliente(MembresiaCliente membresiaCliente) {
		this.membresiaCliente = membresiaCliente;
	}

	public TipoMovimientoBene getTipoMovimientoBene() {
		return this.tipoMovimientoBene;
	}

	public void setTipoMovimientoBene(TipoMovimientoBene tipoMovimientoBene) {
		this.tipoMovimientoBene = tipoMovimientoBene;
	}

}