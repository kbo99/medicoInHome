package com.medico.home.commons.doctor.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_enfermedad database table.
 * 
 */
@Entity
@Table(name="tipo_enfermedad")
@NamedQuery(name="TipoEnfermedad.findAll", query="SELECT t FROM TipoEnfermedad t")
public class TipoEnfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ten_id")
	private int tenId;

	@Column(name="ten_desc")
	private String tenDesc;

	@Column(name="ten_nombre")
	private String tenNombre;

	//bi-directional many-to-one association to Enfermedad
	@OneToMany(mappedBy="tipoEnfermedad")
	private List<Enfermedad> enfermedads;

	public TipoEnfermedad() {
	}

	public int getTenId() {
		return this.tenId;
	}

	public void setTenId(int tenId) {
		this.tenId = tenId;
	}

	public String getTenDesc() {
		return this.tenDesc;
	}

	public void setTenDesc(String tenDesc) {
		this.tenDesc = tenDesc;
	}

	public String getTenNombre() {
		return this.tenNombre;
	}

	public void setTenNombre(String tenNombre) {
		this.tenNombre = tenNombre;
	}

	public List<Enfermedad> getEnfermedads() {
		return this.enfermedads;
	}

	public void setEnfermedads(List<Enfermedad> enfermedads) {
		this.enfermedads = enfermedads;
	}

	public Enfermedad addEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().add(enfermedad);
		enfermedad.setTipoEnfermedad(this);

		return enfermedad;
	}

	public Enfermedad removeEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().remove(enfermedad);
		enfermedad.setTipoEnfermedad(null);

		return enfermedad;
	}

}