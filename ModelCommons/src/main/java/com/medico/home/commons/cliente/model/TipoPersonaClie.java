package com.medico.home.commons.cliente.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_persona_clie database table.
 * 
 */
@Entity
@Table(name="tipo_persona_clie")
@NamedQuery(name="TipoPersonaClie.findAll", query="SELECT t FROM TipoPersonaClie t")
public class TipoPersonaClie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tpc_id")
	private int tpcId;

	@Column(name="tpc_desc")
	private String tpcDesc;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="tipoPersonaClie")
	private List<Cliente> clientes;

	public TipoPersonaClie() {
	}

	public int getTpcId() {
		return this.tpcId;
	}

	public void setTpcId(int tpcId) {
		this.tpcId = tpcId;
	}

	public String getTpcDesc() {
		return this.tpcDesc;
	}

	public void setTpcDesc(String tpcDesc) {
		this.tpcDesc = tpcDesc;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setTipoPersonaClie(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setTipoPersonaClie(null);

		return cliente;
	}

}