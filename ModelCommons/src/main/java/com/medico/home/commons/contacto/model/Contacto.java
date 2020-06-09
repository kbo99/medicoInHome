package com.medico.home.commons.contacto.model;

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

import com.medico.home.commons.direccion.model.Direccion;


/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ctn_id")
	private int ctnId;

	@Column(name="ctn_activo")
	private String ctnActivo;

	@Column(name="ctn_celular")
	private String ctnCelular;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ctn_horario")
	private Date ctnHorario;

	@Column(name="ctn_tel_asis")
	private String ctnTelAsis;

	@Column(name="ctn_telefo")
	private String ctnTelefo;

	//bi-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name="dir_id")
	private Direccion direccion;

	//bi-directional many-to-one association to ContactoDoctor
	@OneToMany(mappedBy="contacto")
	private List<ContactoDoctor> contactoDoctors;

	//bi-directional many-to-one association to ContactoFarmacia
	@OneToMany(mappedBy="contacto")
	private List<ContactoFarmacia> contactoFarmacias;

	public Contacto() {
	}

	public int getCtnId() {
		return this.ctnId;
	}

	public void setCtnId(int ctnId) {
		this.ctnId = ctnId;
	}

	public String getCtnActivo() {
		return this.ctnActivo;
	}

	public void setCtnActivo(String ctnActivo) {
		this.ctnActivo = ctnActivo;
	}

	public String getCtnCelular() {
		return this.ctnCelular;
	}

	public void setCtnCelular(String ctnCelular) {
		this.ctnCelular = ctnCelular;
	}

	public Date getCtnHorario() {
		return this.ctnHorario;
	}

	public void setCtnHorario(Date ctnHorario) {
		this.ctnHorario = ctnHorario;
	}

	public String getCtnTelAsis() {
		return this.ctnTelAsis;
	}

	public void setCtnTelAsis(String ctnTelAsis) {
		this.ctnTelAsis = ctnTelAsis;
	}

	public String getCtnTelefo() {
		return this.ctnTelefo;
	}

	public void setCtnTelefo(String ctnTelefo) {
		this.ctnTelefo = ctnTelefo;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<ContactoDoctor> getContactoDoctors() {
		return this.contactoDoctors;
	}

	public void setContactoDoctors(List<ContactoDoctor> contactoDoctors) {
		this.contactoDoctors = contactoDoctors;
	}

	public ContactoDoctor addContactoDoctor(ContactoDoctor contactoDoctor) {
		getContactoDoctors().add(contactoDoctor);
		contactoDoctor.setContacto(this);

		return contactoDoctor;
	}

	public ContactoDoctor removeContactoDoctor(ContactoDoctor contactoDoctor) {
		getContactoDoctors().remove(contactoDoctor);
		contactoDoctor.setContacto(null);

		return contactoDoctor;
	}

	public List<ContactoFarmacia> getContactoFarmacias() {
		return this.contactoFarmacias;
	}

	public void setContactoFarmacias(List<ContactoFarmacia> contactoFarmacias) {
		this.contactoFarmacias = contactoFarmacias;
	}

	public ContactoFarmacia addContactoFarmacia(ContactoFarmacia contactoFarmacia) {
		getContactoFarmacias().add(contactoFarmacia);
		contactoFarmacia.setContacto(this);

		return contactoFarmacia;
	}

	public ContactoFarmacia removeContactoFarmacia(ContactoFarmacia contactoFarmacia) {
		getContactoFarmacias().remove(contactoFarmacia);
		contactoFarmacia.setContacto(null);

		return contactoFarmacia;
	}

}