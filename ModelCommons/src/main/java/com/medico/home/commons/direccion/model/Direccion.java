package com.medico.home.commons.direccion.model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.medico.home.commons.cliente.model.ClienteDireccion;
import com.medico.home.commons.contacto.model.Contacto;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Entity
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dir_id")
	private int dirId;

	@Column(name="dir_calle")
	private String dirCalle;

	@Column(name="dir_entre_calle_dos")	
	private String dirEntreCalleDos;

	@Column(name="dir_entre_calle_uno")
	private String dirEntreCalleUno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dir_falta")
	private Date dirFalta;

	@Column(name="dir_num_ext")
	private String dirNumExt;

	@Column(name="dir_num_int")
	private String dirNumInt;

	@Column(name="dir_referencias")
	private String dirReferencias;

	//bi-directional many-to-one association to ClienteDireccion
	@OneToMany(mappedBy="direccion")
	private List<ClienteDireccion> clienteDireccions;

	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="direccion")
	private List<Contacto> contactos;

	//bi-directional many-to-one association to Colonia
	@ManyToOne
	@JoinColumn(name="col_id")
	private Colonia colonia;

	public Direccion() {
	}

	public int getDirId() {
		return this.dirId;
	}

	public void setDirId(int dirId) {
		this.dirId = dirId;
	}

	public String getDirCalle() {
		return this.dirCalle;
	}

	public void setDirCalle(String dirCalle) {
		this.dirCalle = dirCalle;
	}

	public String getDirEntreCalleDos() {
		return this.dirEntreCalleDos;
	}

	public void setDirEntreCalleDos(String dirEntreCalleDos) {
		this.dirEntreCalleDos = dirEntreCalleDos;
	}

	public String getDirEntreCalleUno() {
		return this.dirEntreCalleUno;
	}

	public void setDirEntreCalleUno(String dirEntreCalleUno) {
		this.dirEntreCalleUno = dirEntreCalleUno;
	}

	public Date getDirFalta() {
		return this.dirFalta;
	}

	public void setDirFalta(Date dirFalta) {
		this.dirFalta = dirFalta;
	}

	public String getDirNumExt() {
		return this.dirNumExt;
	}

	public void setDirNumExt(String dirNumExt) {
		this.dirNumExt = dirNumExt;
	}

	public String getDirNumInt() {
		return this.dirNumInt;
	}

	public void setDirNumInt(String dirNumInt) {
		this.dirNumInt = dirNumInt;
	}

	public String getDirReferencias() {
		return this.dirReferencias;
	}

	public void setDirReferencias(String dirReferencias) {
		this.dirReferencias = dirReferencias;
	}

	public List<ClienteDireccion> getClienteDireccions() {
		return this.clienteDireccions;
	}

	public void setClienteDireccions(List<ClienteDireccion> clienteDireccions) {
		this.clienteDireccions = clienteDireccions;
	}

	public ClienteDireccion addClienteDireccion(ClienteDireccion clienteDireccion) {
		getClienteDireccions().add(clienteDireccion);
		clienteDireccion.setDireccion(this);

		return clienteDireccion;
	}

	public ClienteDireccion removeClienteDireccion(ClienteDireccion clienteDireccion) {
		getClienteDireccions().remove(clienteDireccion);
		clienteDireccion.setDireccion(null);

		return clienteDireccion;
	}

	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setDireccion(this);

		return contacto;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setDireccion(null);

		return contacto;
	}

	public Colonia getColonia() {
		return this.colonia;
	}

	public void setColonia(Colonia colonia) {
		this.colonia = colonia;
	}

}