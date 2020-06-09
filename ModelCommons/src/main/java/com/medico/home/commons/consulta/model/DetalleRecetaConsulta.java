package com.medico.home.commons.consulta.model;

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

import com.medico.home.commons.servicio.model.DetalleServicioFarmacia;


/**
 * The persistent class for the detalle_receta_consulta database table.
 * 
 */
@Entity
@Table(name="detalle_receta_consulta")
@NamedQuery(name="DetalleRecetaConsulta.findAll", query="SELECT d FROM DetalleRecetaConsulta d")
public class DetalleRecetaConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="drc_id")
	private int drcId;

	@Column(name="drc_indicaciones")
	private String drcIndicaciones;

	@Column(name="drc_medicamento")
	private String drcMedicamento;

	//bi-directional many-to-one association to RecetaConsulta
	@ManyToOne
	@JoinColumn(name="rcc_id")
	private RecetaConsulta recetaConsulta;

	//bi-directional many-to-one association to DetalleServicioFarmacia
	@OneToMany(mappedBy="detalleRecetaConsulta")
	private List<DetalleServicioFarmacia> detalleServicioFarmacias;

	public DetalleRecetaConsulta() {
	}

	public int getDrcId() {
		return this.drcId;
	}

	public void setDrcId(int drcId) {
		this.drcId = drcId;
	}

	public String getDrcIndicaciones() {
		return this.drcIndicaciones;
	}

	public void setDrcIndicaciones(String drcIndicaciones) {
		this.drcIndicaciones = drcIndicaciones;
	}

	public String getDrcMedicamento() {
		return this.drcMedicamento;
	}

	public void setDrcMedicamento(String drcMedicamento) {
		this.drcMedicamento = drcMedicamento;
	}

	public RecetaConsulta getRecetaConsulta() {
		return this.recetaConsulta;
	}

	public void setRecetaConsulta(RecetaConsulta recetaConsulta) {
		this.recetaConsulta = recetaConsulta;
	}

	public List<DetalleServicioFarmacia> getDetalleServicioFarmacias() {
		return this.detalleServicioFarmacias;
	}

	public void setDetalleServicioFarmacias(List<DetalleServicioFarmacia> detalleServicioFarmacias) {
		this.detalleServicioFarmacias = detalleServicioFarmacias;
	}

	public DetalleServicioFarmacia addDetalleServicioFarmacia(DetalleServicioFarmacia detalleServicioFarmacia) {
		getDetalleServicioFarmacias().add(detalleServicioFarmacia);
		detalleServicioFarmacia.setDetalleRecetaConsulta(this);

		return detalleServicioFarmacia;
	}

	public DetalleServicioFarmacia removeDetalleServicioFarmacia(DetalleServicioFarmacia detalleServicioFarmacia) {
		getDetalleServicioFarmacias().remove(detalleServicioFarmacia);
		detalleServicioFarmacia.setDetalleRecetaConsulta(null);

		return detalleServicioFarmacia;
	}

}