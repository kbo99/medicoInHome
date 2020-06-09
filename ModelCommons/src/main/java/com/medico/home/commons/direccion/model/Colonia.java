package com.medico.home.commons.direccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the colonia database table.
 * 
 */
@Entity
@NamedQuery(name="Colonia.findAll", query="SELECT c FROM Colonia c")
public class Colonia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="col_id")
	private int colId;

	@Column(name="col_cp")
	private String colCp;

	@Column(name="col_nom")
	private String colNom;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="mun_id")
	private Municipio municipio;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="colonia")
	private List<Direccion> direccions;

	public Colonia() {
	}

	public int getColId() {
		return this.colId;
	}

	public void setColId(int colId) {
		this.colId = colId;
	}

	public String getColCp() {
		return this.colCp;
	}

	public void setColCp(String colCp) {
		this.colCp = colCp;
	}

	public String getColNom() {
		return this.colNom;
	}

	public void setColNom(String colNom) {
		this.colNom = colNom;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setColonia(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setColonia(null);

		return direccion;
	}

}