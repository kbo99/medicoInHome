package com.medico.home.commons.cliente.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.medico.home.commons.doctor.model.Paciente;
import com.medico.home.commons.membresia.model.MembresiaCliente;
import com.medico.home.commons.persona.model.Persona;


/**
 * The persistent class for the cliente_persona database table.
 * 
 */
@Entity
@Table(name="cliente_persona")
@NamedQuery(name="ClientePersona.findAll", query="SELECT c FROM ClientePersona c")
public class ClientePersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cpe_id")
	private int cpeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cpe_fregistro")
	private Date cpeFregistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cpe_fultima_mod")
	private Date cpeFultimaMod;

	
	//bi-directional many-to-one association to Cliente
	@OneToOne
	@JoinColumn(name="cli_id")
	private Cliente cliente;

	//bi-directional many-to-one association to PerfilPersonaCliente
	@OneToOne
	@JoinColumn(name="ppc_id")
	private PerfilPersonaCliente perfilPersonaCliente;

	//bi-directional many-to-one association to Persona
	
	@OneToOne
	@JoinColumn(name="per_id")
	private Persona persona;


	public ClientePersona() {
	}

	public int getCpeId() {
		return this.cpeId;
	}

	public void setCpeId(int cpeId) {
		this.cpeId = cpeId;
	}

	public Date getCpeFregistro() {
		return this.cpeFregistro;
	}

	public void setCpeFregistro(Date cpeFregistro) {
		this.cpeFregistro = cpeFregistro;
	}

	public Date getCpeFultimaMod() {
		return this.cpeFultimaMod;
	}

	public void setCpeFultimaMod(Date cpeFultimaMod) {
		this.cpeFultimaMod = cpeFultimaMod;
	}

	

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PerfilPersonaCliente getPerfilPersonaCliente() {
		return this.perfilPersonaCliente;
	}

	public void setPerfilPersonaCliente(PerfilPersonaCliente perfilPersonaCliente) {
		this.perfilPersonaCliente = perfilPersonaCliente;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}



}