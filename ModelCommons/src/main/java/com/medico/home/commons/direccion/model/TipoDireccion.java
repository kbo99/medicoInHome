package com.medico.home.commons.direccion.model;

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

import com.medico.home.commons.cliente.model.ClienteDireccion;


/**
 * The persistent class for the tipo_direccion database table.
 * 
 */
@Entity
@Table(name="tipo_direccion")
@NamedQuery(name="TipoDireccion.findAll", query="SELECT t FROM TipoDireccion t")
public class TipoDireccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tpd_id")
	private int tpdId;

	@Column(name="tpd_desc")
	private String tpdDesc;

	@Column(name="tpd_nombre")
	private String tpdNombre;

	//bi-directional many-to-one association to ClienteDireccion
	@OneToMany(mappedBy="tipoDireccion")
	private List<ClienteDireccion> clienteDireccions;

	public TipoDireccion() {
	}

	public int getTpdId() {
		return this.tpdId;
	}

	public void setTpdId(int tpdId) {
		this.tpdId = tpdId;
	}

	public String getTpdDesc() {
		return this.tpdDesc;
	}

	public void setTpdDesc(String tpdDesc) {
		this.tpdDesc = tpdDesc;
	}

	public String getTpdNombre() {
		return this.tpdNombre;
	}

	public void setTpdNombre(String tpdNombre) {
		this.tpdNombre = tpdNombre;
	}

	public List<ClienteDireccion> getClienteDireccions() {
		return this.clienteDireccions;
	}

	public void setClienteDireccions(List<ClienteDireccion> clienteDireccions) {
		this.clienteDireccions = clienteDireccions;
	}

	public ClienteDireccion addClienteDireccion(ClienteDireccion clienteDireccion) {
		getClienteDireccions().add(clienteDireccion);
		clienteDireccion.setTipoDireccion(this);

		return clienteDireccion;
	}

	public ClienteDireccion removeClienteDireccion(ClienteDireccion clienteDireccion) {
		getClienteDireccions().remove(clienteDireccion);
		clienteDireccion.setTipoDireccion(null);

		return clienteDireccion;
	}

}