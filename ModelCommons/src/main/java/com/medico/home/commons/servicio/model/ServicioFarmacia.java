package com.medico.home.commons.servicio.model;

import java.io.Serializable;
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

import com.medico.home.commons.contacto.model.ContactoFarmacia;


/**
 * The persistent class for the servicio_farmacia database table.
 * 
 */
@Entity
@Table(name="servicio_farmacia")
@NamedQuery(name="ServicioFarmacia.findAll", query="SELECT s FROM ServicioFarmacia s")
public class ServicioFarmacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="srf_id")
	private int srfId;

	@Column(name="srf_person_atiende")
	private String srfPersonAtiende;

	//bi-directional many-to-one association to DetalleServicioFarmacia
	@OneToMany(mappedBy="servicioFarmacia")
	private List<DetalleServicioFarmacia> detalleServicioFarmacias;

	//bi-directional many-to-one association to ContactoFarmacia
	@ManyToOne
	@JoinColumn(name="cof_id")
	private ContactoFarmacia contactoFarmacia;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="ser_id")
	private Servicio servicio;

	public ServicioFarmacia() {
	}

	public int getSrfId() {
		return this.srfId;
	}

	public void setSrfId(int srfId) {
		this.srfId = srfId;
	}

	public String getSrfPersonAtiende() {
		return this.srfPersonAtiende;
	}

	public void setSrfPersonAtiende(String srfPersonAtiende) {
		this.srfPersonAtiende = srfPersonAtiende;
	}

	public List<DetalleServicioFarmacia> getDetalleServicioFarmacias() {
		return this.detalleServicioFarmacias;
	}

	public void setDetalleServicioFarmacias(List<DetalleServicioFarmacia> detalleServicioFarmacias) {
		this.detalleServicioFarmacias = detalleServicioFarmacias;
	}

	public DetalleServicioFarmacia addDetalleServicioFarmacia(DetalleServicioFarmacia detalleServicioFarmacia) {
		getDetalleServicioFarmacias().add(detalleServicioFarmacia);
		detalleServicioFarmacia.setServicioFarmacia(this);

		return detalleServicioFarmacia;
	}

	public DetalleServicioFarmacia removeDetalleServicioFarmacia(DetalleServicioFarmacia detalleServicioFarmacia) {
		getDetalleServicioFarmacias().remove(detalleServicioFarmacia);
		detalleServicioFarmacia.setServicioFarmacia(null);

		return detalleServicioFarmacia;
	}

	public ContactoFarmacia getContactoFarmacia() {
		return this.contactoFarmacia;
	}

	public void setContactoFarmacia(ContactoFarmacia contactoFarmacia) {
		this.contactoFarmacia = contactoFarmacia;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}