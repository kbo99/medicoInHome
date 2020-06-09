package com.medico.home.commons.beneficio.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.medico.home.commons.membresia.model.MovimientoBeneficioMem;


/**
 * The persistent class for the tipo_movimiento_bene database table.
 * 
 */
@Entity
@Table(name="tipo_movimiento_bene")
@NamedQuery(name="TipoMovimientoBene.findAll", query="SELECT t FROM TipoMovimientoBene t")
public class TipoMovimientoBene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tmb_id")
	private int tmbId;

	@Column(name="tmb_nombre")
	private String tmbNombre;

	//bi-directional many-to-one association to MovimientoBeneficioMem
	@OneToMany(mappedBy="tipoMovimientoBene")
	private List<MovimientoBeneficioMem> movimientoBeneficioMems;

	public TipoMovimientoBene() {
	}

	public int getTmbId() {
		return this.tmbId;
	}

	public void setTmbId(int tmbId) {
		this.tmbId = tmbId;
	}

	public String getTmbNombre() {
		return this.tmbNombre;
	}

	public void setTmbNombre(String tmbNombre) {
		this.tmbNombre = tmbNombre;
	}

	public List<MovimientoBeneficioMem> getMovimientoBeneficioMems() {
		return this.movimientoBeneficioMems;
	}

	public void setMovimientoBeneficioMems(List<MovimientoBeneficioMem> movimientoBeneficioMems) {
		this.movimientoBeneficioMems = movimientoBeneficioMems;
	}

	public MovimientoBeneficioMem addMovimientoBeneficioMem(MovimientoBeneficioMem movimientoBeneficioMem) {
		getMovimientoBeneficioMems().add(movimientoBeneficioMem);
		movimientoBeneficioMem.setTipoMovimientoBene(this);

		return movimientoBeneficioMem;
	}

	public MovimientoBeneficioMem removeMovimientoBeneficioMem(MovimientoBeneficioMem movimientoBeneficioMem) {
		getMovimientoBeneficioMems().remove(movimientoBeneficioMem);
		movimientoBeneficioMem.setTipoMovimientoBene(null);

		return movimientoBeneficioMem;
	}

}