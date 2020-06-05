package com.medico.home.commons.usuario.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="grp_id")
	private int grpId;

	@Column(name="grp_desc")
	private String grpDesc;

	@Column(name="grp_estatus")
	private String grpEstatus;

	@Column(name="grp_nombre")
	private String grpNombre;

	//bi-directional many-to-many association to Usuario
	@ManyToMany
	@JoinTable(
		name="usu_grupo"
		, joinColumns={
			@JoinColumn(name="grp_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="usu_id")
			}
		)
	private List<Usuario> usuarios;

	public Grupo() {
	}

	public int getGrpId() {
		return this.grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getGrpDesc() {
		return this.grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

	public String getGrpEstatus() {
		return this.grpEstatus;
	}

	public void setGrpEstatus(String grpEstatus) {
		this.grpEstatus = grpEstatus;
	}

	public String getGrpNombre() {
		return this.grpNombre;
	}

	public void setGrpNombre(String grpNombre) {
		this.grpNombre = grpNombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}