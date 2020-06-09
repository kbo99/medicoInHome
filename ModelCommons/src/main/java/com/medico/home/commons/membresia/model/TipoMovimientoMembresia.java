package com.medico.home.commons.membresia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_movimiento_membresia database table.
 * 
 */
@Entity
@Table(name="tipo_movimiento_membresia")
@NamedQuery(name="TipoMovimientoMembresia.findAll", query="SELECT t FROM TipoMovimientoMembresia t")
public class TipoMovimientoMembresia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tmm_id")
	private int tmmId;

	@Column(name="tmm_nombre")
	private String tmmNombre;

	//bi-directional many-to-one association to MovimientoMembresia
	@OneToMany(mappedBy="tipoMovimientoMembresia")
	private List<MovimientoMembresia> movimientoMembresias;

	public TipoMovimientoMembresia() {
	}

	public int getTmmId() {
		return this.tmmId;
	}

	public void setTmmId(int tmmId) {
		this.tmmId = tmmId;
	}

	public String getTmmNombre() {
		return this.tmmNombre;
	}

	public void setTmmNombre(String tmmNombre) {
		this.tmmNombre = tmmNombre;
	}

	public List<MovimientoMembresia> getMovimientoMembresias() {
		return this.movimientoMembresias;
	}

	public void setMovimientoMembresias(List<MovimientoMembresia> movimientoMembresias) {
		this.movimientoMembresias = movimientoMembresias;
	}

	public MovimientoMembresia addMovimientoMembresia(MovimientoMembresia movimientoMembresia) {
		getMovimientoMembresias().add(movimientoMembresia);
		movimientoMembresia.setTipoMovimientoMembresia(this);

		return movimientoMembresia;
	}

	public MovimientoMembresia removeMovimientoMembresia(MovimientoMembresia movimientoMembresia) {
		getMovimientoMembresias().remove(movimientoMembresia);
		movimientoMembresia.setTipoMovimientoMembresia(null);

		return movimientoMembresia;
	}

}