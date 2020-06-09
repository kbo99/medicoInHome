package com.medico.home.commons.servicio.model;

import java.io.Serializable;
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
import javax.persistence.Table;

import com.medico.home.commons.consulta.model.DetalleRecetaConsulta;
import com.medico.home.commons.farmacia.model.FaltanteDetalleFarmacia;


/**
 * The persistent class for the detalle_servicio_farmacia database table.
 * 
 */
@Entity
@Table(name="detalle_servicio_farmacia")
@NamedQuery(name="DetalleServicioFarmacia.findAll", query="SELECT d FROM DetalleServicioFarmacia d")
public class DetalleServicioFarmacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dsf_id")
	private int dsfId;

	@Column(name="dsf_cant_prov")
	private int dsfCantProv;

	@Column(name="dsf_cant_sol")
	private int dsfCantSol;

	//bi-directional many-to-one association to DetalleRecetaConsulta
	@ManyToOne
	@JoinColumn(name="drc_id")
	private DetalleRecetaConsulta detalleRecetaConsulta;

	//bi-directional many-to-one association to ServicioFarmacia
	@ManyToOne
	@JoinColumn(name="srf_id")
	private ServicioFarmacia servicioFarmacia;

	//bi-directional many-to-one association to FaltanteDetalleFarmacia
	@OneToMany(mappedBy="detalleServicioFarmacia")
	private List<FaltanteDetalleFarmacia> faltanteDetalleFarmacias;

	public DetalleServicioFarmacia() {
	}

	public int getDsfId() {
		return this.dsfId;
	}

	public void setDsfId(int dsfId) {
		this.dsfId = dsfId;
	}

	public int getDsfCantProv() {
		return this.dsfCantProv;
	}

	public void setDsfCantProv(int dsfCantProv) {
		this.dsfCantProv = dsfCantProv;
	}

	public int getDsfCantSol() {
		return this.dsfCantSol;
	}

	public void setDsfCantSol(int dsfCantSol) {
		this.dsfCantSol = dsfCantSol;
	}

	public DetalleRecetaConsulta getDetalleRecetaConsulta() {
		return this.detalleRecetaConsulta;
	}

	public void setDetalleRecetaConsulta(DetalleRecetaConsulta detalleRecetaConsulta) {
		this.detalleRecetaConsulta = detalleRecetaConsulta;
	}

	public ServicioFarmacia getServicioFarmacia() {
		return this.servicioFarmacia;
	}

	public void setServicioFarmacia(ServicioFarmacia servicioFarmacia) {
		this.servicioFarmacia = servicioFarmacia;
	}

	public List<FaltanteDetalleFarmacia> getFaltanteDetalleFarmacias() {
		return this.faltanteDetalleFarmacias;
	}

	public void setFaltanteDetalleFarmacias(List<FaltanteDetalleFarmacia> faltanteDetalleFarmacias) {
		this.faltanteDetalleFarmacias = faltanteDetalleFarmacias;
	}

	public FaltanteDetalleFarmacia addFaltanteDetalleFarmacia(FaltanteDetalleFarmacia faltanteDetalleFarmacia) {
		getFaltanteDetalleFarmacias().add(faltanteDetalleFarmacia);
		faltanteDetalleFarmacia.setDetalleServicioFarmacia(this);

		return faltanteDetalleFarmacia;
	}

	public FaltanteDetalleFarmacia removeFaltanteDetalleFarmacia(FaltanteDetalleFarmacia faltanteDetalleFarmacia) {
		getFaltanteDetalleFarmacias().remove(faltanteDetalleFarmacia);
		faltanteDetalleFarmacia.setDetalleServicioFarmacia(null);

		return faltanteDetalleFarmacia;
	}

}