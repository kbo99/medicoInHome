package com.medico.home.commons.farmacia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.medico.home.commons.contacto.model.ContactoFarmacia;


/**
 * The persistent class for the farmacia database table.
 * 
 */
@Entity
@NamedQuery(name="Farmacia.findAll", query="SELECT f FROM Farmacia f")
public class Farmacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="far_id")
	private int farId;

	@Column(name="far_activa")
	private String farActiva;

	@Column(name="far_nombre")
	private String farNombre;

	//bi-directional many-to-one association to ContactoFarmacia
	@OneToMany(mappedBy="farmacia")
	private List<ContactoFarmacia> contactoFarmacias;

	public Farmacia() {
	}

	public int getFarId() {
		return this.farId;
	}

	public void setFarId(int farId) {
		this.farId = farId;
	}

	public String getFarActiva() {
		return this.farActiva;
	}

	public void setFarActiva(String farActiva) {
		this.farActiva = farActiva;
	}

	public String getFarNombre() {
		return this.farNombre;
	}

	public void setFarNombre(String farNombre) {
		this.farNombre = farNombre;
	}

	public List<ContactoFarmacia> getContactoFarmacias() {
		return this.contactoFarmacias;
	}

	public void setContactoFarmacias(List<ContactoFarmacia> contactoFarmacias) {
		this.contactoFarmacias = contactoFarmacias;
	}

	public ContactoFarmacia addContactoFarmacia(ContactoFarmacia contactoFarmacia) {
		getContactoFarmacias().add(contactoFarmacia);
		contactoFarmacia.setFarmacia(this);

		return contactoFarmacia;
	}

	public ContactoFarmacia removeContactoFarmacia(ContactoFarmacia contactoFarmacia) {
		getContactoFarmacias().remove(contactoFarmacia);
		contactoFarmacia.setFarmacia(null);

		return contactoFarmacia;
	}

}