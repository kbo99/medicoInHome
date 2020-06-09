package com.medico.home.commons.membresia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the movimiento_membresia database table.
 * 
 */
@Entity
@Table(name="movimiento_membresia")
@NamedQuery(name="MovimientoMembresia.findAll", query="SELECT m FROM MovimientoMembresia m")
public class MovimientoMembresia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mom_id")
	private int momId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mom_fmodficiacion")
	private Date momFmodficiacion;

	@Column(name="mom_observacion")
	private String momObservacion;

	@Column(name="usu_modifica")
	private String usuModifica;

	//bi-directional many-to-one association to MembresiaCliente
	@ManyToOne
	@JoinColumn(name="mec_id")
	private MembresiaCliente membresiaCliente;

	//bi-directional many-to-one association to TipoMovimientoMembresia
	@ManyToOne
	@JoinColumn(name="tmm_id")
	private TipoMovimientoMembresia tipoMovimientoMembresia;

	public MovimientoMembresia() {
	}

	public int getMomId() {
		return this.momId;
	}

	public void setMomId(int momId) {
		this.momId = momId;
	}

	public Date getMomFmodficiacion() {
		return this.momFmodficiacion;
	}

	public void setMomFmodficiacion(Date momFmodficiacion) {
		this.momFmodficiacion = momFmodficiacion;
	}

	public String getMomObservacion() {
		return this.momObservacion;
	}

	public void setMomObservacion(String momObservacion) {
		this.momObservacion = momObservacion;
	}

	public String getUsuModifica() {
		return this.usuModifica;
	}

	public void setUsuModifica(String usuModifica) {
		this.usuModifica = usuModifica;
	}

	public MembresiaCliente getMembresiaCliente() {
		return this.membresiaCliente;
	}

	public void setMembresiaCliente(MembresiaCliente membresiaCliente) {
		this.membresiaCliente = membresiaCliente;
	}

	public TipoMovimientoMembresia getTipoMovimientoMembresia() {
		return this.tipoMovimientoMembresia;
	}

	public void setTipoMovimientoMembresia(TipoMovimientoMembresia tipoMovimientoMembresia) {
		this.tipoMovimientoMembresia = tipoMovimientoMembresia;
	}

}