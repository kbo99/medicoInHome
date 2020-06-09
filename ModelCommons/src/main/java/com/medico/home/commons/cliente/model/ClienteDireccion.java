package com.medico.home.commons.cliente.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.medico.home.commons.direccion.model.Direccion;
import com.medico.home.commons.direccion.model.TipoDireccion;


/**
 * The persistent class for the cliente_direccion database table.
 * 
 */
@Entity
@Table(name="cliente_direccion")
@NamedQuery(name="ClienteDireccion.findAll", query="SELECT c FROM ClienteDireccion c")
public class ClienteDireccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cld_id")
	private int cldId;

	@Column(name="cld_activa")
	private String cldActiva;

	//bi-directional many-to-one association to ClientePersona
	@ManyToOne
	@JoinColumn(name="cpe_id")
	private ClientePersona clientePersona;

	//bi-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name="dir_id")
	private Direccion direccion;

	//bi-directional many-to-one association to TipoDireccion
	@ManyToOne
	@JoinColumn(name="tpd_id")
	private TipoDireccion tipoDireccion;

	public ClienteDireccion() {
	}

	public int getCldId() {
		return this.cldId;
	}

	public void setCldId(int cldId) {
		this.cldId = cldId;
	}

	public String getCldActiva() {
		return this.cldActiva;
	}

	public void setCldActiva(String cldActiva) {
		this.cldActiva = cldActiva;
	}

	public ClientePersona getClientePersona() {
		return this.clientePersona;
	}

	public void setClientePersona(ClientePersona clientePersona) {
		this.clientePersona = clientePersona;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public TipoDireccion getTipoDireccion() {
		return this.tipoDireccion;
	}

	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

}