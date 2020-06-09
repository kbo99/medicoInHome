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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	//bi-directional many-to-one association to ClienteDireccion
	@OneToMany(mappedBy="clientePersona")
	private List<ClienteDireccion> clienteDireccions;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cli_id")
	private Cliente cliente;

	//bi-directional many-to-one association to PerfilPersonaCliente
	@ManyToOne
	@JoinColumn(name="ppc_id")
	private PerfilPersonaCliente perfilPersonaCliente;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_id")
	private Persona persona;

	//bi-directional many-to-one association to MembresiaCliente
	@OneToMany(mappedBy="clientePersona")
	private List<MembresiaCliente> membresiaClientes;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="clientePersona")
	private List<Paciente> pacientes;

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

	public List<ClienteDireccion> getClienteDireccions() {
		return this.clienteDireccions;
	}

	public void setClienteDireccions(List<ClienteDireccion> clienteDireccions) {
		this.clienteDireccions = clienteDireccions;
	}

	public ClienteDireccion addClienteDireccion(ClienteDireccion clienteDireccion) {
		getClienteDireccions().add(clienteDireccion);
		clienteDireccion.setClientePersona(this);

		return clienteDireccion;
	}

	public ClienteDireccion removeClienteDireccion(ClienteDireccion clienteDireccion) {
		getClienteDireccions().remove(clienteDireccion);
		clienteDireccion.setClientePersona(null);

		return clienteDireccion;
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

	public List<MembresiaCliente> getMembresiaClientes() {
		return this.membresiaClientes;
	}

	public void setMembresiaClientes(List<MembresiaCliente> membresiaClientes) {
		this.membresiaClientes = membresiaClientes;
	}

	public MembresiaCliente addMembresiaCliente(MembresiaCliente membresiaCliente) {
		getMembresiaClientes().add(membresiaCliente);
		membresiaCliente.setClientePersona(this);

		return membresiaCliente;
	}

	public MembresiaCliente removeMembresiaCliente(MembresiaCliente membresiaCliente) {
		getMembresiaClientes().remove(membresiaCliente);
		membresiaCliente.setClientePersona(null);

		return membresiaCliente;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setClientePersona(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setClientePersona(null);

		return paciente;
	}

}