package com.medico.home.commons.direccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
@NamedQuery(name="Pai.findAll", query="SELECT p FROM Pai p")
public class Pai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pai_id")
	private int paiId;

	@Column(name="pai_abre")
	private String paiAbre;

	@Column(name="pai_nombre")
	private String paiNombre;

	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="pai")
	private List<Entidad> entidads;

	//bi-directional many-to-one association to RegionPai
	@ManyToOne
	@JoinColumn(name="rep_id")
	private RegionPai regionPai;

	public Pai() {
	}

	public int getPaiId() {
		return this.paiId;
	}

	public void setPaiId(int paiId) {
		this.paiId = paiId;
	}

	public String getPaiAbre() {
		return this.paiAbre;
	}

	public void setPaiAbre(String paiAbre) {
		this.paiAbre = paiAbre;
	}

	public String getPaiNombre() {
		return this.paiNombre;
	}

	public void setPaiNombre(String paiNombre) {
		this.paiNombre = paiNombre;
	}

	public List<Entidad> getEntidads() {
		return this.entidads;
	}

	public void setEntidads(List<Entidad> entidads) {
		this.entidads = entidads;
	}

	public Entidad addEntidad(Entidad entidad) {
		getEntidads().add(entidad);
		entidad.setPai(this);

		return entidad;
	}

	public Entidad removeEntidad(Entidad entidad) {
		getEntidads().remove(entidad);
		entidad.setPai(null);

		return entidad;
	}

	public RegionPai getRegionPai() {
		return this.regionPai;
	}

	public void setRegionPai(RegionPai regionPai) {
		this.regionPai = regionPai;
	}

}