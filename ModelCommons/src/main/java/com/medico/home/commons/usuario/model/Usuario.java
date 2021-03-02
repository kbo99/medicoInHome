	package com.medico.home.commons.usuario.model;

import java.io.Serializable;
import javax.persistence.*;

import com.medico.home.commons.persona.model.Persona;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usu_id")
	private int usuId;

	@Column(name="usu_estatus")
	private String usuEstatus;

	@Column(name="usu_password")
	private String usuPassword;

	@Column(name="usu_usuario")
	private String usuUsuario;

	@Column
	private Integer perId;
	
	@Transient
	private Persona persona;
	
	//bi-directional many-to-many association to Grupo
	@ManyToMany(mappedBy="usuarios")
	private List<Grupo> grupos;

	public Usuario() {
	}

	public int getUsuId() {
		return this.usuId;
	}

	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}

	public String getUsuEstatus() {
		return this.usuEstatus;
	}

	public void setUsuEstatus(String usuEstatus) {
		this.usuEstatus = usuEstatus;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public String getUsuUsuario() {
		return this.usuUsuario;
	}

	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}

	/**
	 * @return the perId
	 */
	public Integer getPerId() {
		return perId;
	}

	/**
	 * @param perId the perId to set
	 */
	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}




}