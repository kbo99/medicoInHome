package com.medico.home.commons.cliente.model;

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


/**
 * The persistent class for the perfil_persona_cliente database table.
 * 
 */
@Entity
@Table(name="perfil_persona_cliente")
@NamedQuery(name="PerfilPersonaCliente.findAll", query="SELECT p FROM PerfilPersonaCliente p")
public class PerfilPersonaCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ppc_id")
	private int ppcId;

	@Column(name="ppc_desc")
	private String ppcDesc;

	
	public PerfilPersonaCliente() {
	}

	public int getPpcId() {
		return this.ppcId;
	}

	public void setPpcId(int ppcId) {
		this.ppcId = ppcId;
	}

	public String getPpcDesc() {
		return this.ppcDesc;
	}

	public void setPpcDesc(String ppcDesc) {
		this.ppcDesc = ppcDesc;
	}

	

}