package com.medico.home.commons.membresia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.medico.home.commons.cliente.model.ClientePersona;


/**
 * The persistent class for the membresia_cliente database table.
 * 
 */
@Entity
@Table(name="membresia_cliente")
@NamedQuery(name="MembresiaCliente.findAll", query="SELECT m FROM MembresiaCliente m")
public class MembresiaCliente implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3855152909007526658L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mec_id")
	private int mecId;

	@Column(name="mec_duracion")
	private int mecDuracion;

	@Column(name="mec_estatus")
	private String mecEstatus;

	@Temporal(TemporalType.DATE)
	@Column(name="mec_finicio")
	private Date mecFinicio;

	@Temporal(TemporalType.DATE)
	@Column(name="mec_fultima_mod")
	private Date mecFultimaMod;

	@Column(name="mec_fvencimiento")
	private int mecFvencimiento;

	//bi-directional many-to-one association to ClientePersona
	
	@OneToOne
	@JoinColumn(name="cpe_id")
	private ClientePersona clientePersona;

	//bi-directional many-to-one association to Membresia
	@OneToOne
	@JoinColumn(name="mem_id")
	private Membresia membresia;


	
	@Column
	private String mecFolio;

	public MembresiaCliente() {
	}

	public int getMecId() {
		return this.mecId;
	}

	public void setMecId(int mecId) {
		this.mecId = mecId;
	}

	public int getMecDuracion() {
		return this.mecDuracion;
	}

	public void setMecDuracion(int mecDuracion) {
		this.mecDuracion = mecDuracion;
	}

	public String getMecEstatus() {
		return this.mecEstatus;
	}

	public void setMecEstatus(String mecEstatus) {
		this.mecEstatus = mecEstatus;
	}

	public Date getMecFinicio() {
		return this.mecFinicio;
	}

	public void setMecFinicio(Date mecFinicio) {
		this.mecFinicio = mecFinicio;
	}

	public Date getMecFultimaMod() {
		return this.mecFultimaMod;
	}

	public void setMecFultimaMod(Date mecFultimaMod) {
		this.mecFultimaMod = mecFultimaMod;
	}

	public int getMecFvencimiento() {
		return this.mecFvencimiento;
	}

	public void setMecFvencimiento(int mecFvencimiento) {
		this.mecFvencimiento = mecFvencimiento;
	}

	public ClientePersona getClientePersona() {
		return this.clientePersona;
	}

	public void setClientePersona(ClientePersona clientePersona) {
		this.clientePersona = clientePersona;
	}

	public Membresia getMembresia() {
		return this.membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	


	/**
	 * @return the mecFolio
	 */
	public String getMecFolio() {
		return mecFolio;
	}

	/**
	 * @param mecFolio the mecFolio to set
	 */
	public void setMecFolio(String mecFolio) {
		this.mecFolio = mecFolio;
	}
	
	

}