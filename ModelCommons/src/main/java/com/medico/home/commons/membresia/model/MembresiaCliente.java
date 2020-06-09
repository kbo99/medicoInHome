package com.medico.home.commons.membresia.model;

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

import com.medico.home.commons.cliente.model.ClientePersona;


/**
 * The persistent class for the membresia_cliente database table.
 * 
 */
@Entity
@Table(name="membresia_cliente")
@NamedQuery(name="MembresiaCliente.findAll", query="SELECT m FROM MembresiaCliente m")
public class MembresiaCliente implements Serializable {
	private static final long serialVersionUID = 1L;

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
	@ManyToOne
	@JoinColumn(name="cpe_id")
	private ClientePersona clientePersona;

	//bi-directional many-to-one association to Membresia
	@ManyToOne
	@JoinColumn(name="mem_id")
	private Membresia membresia;

	//bi-directional many-to-one association to MovimientoBeneficioMem
	@OneToMany(mappedBy="membresiaCliente")
	private List<MovimientoBeneficioMem> movimientoBeneficioMems;

	//bi-directional many-to-one association to MovimientoMembresia
	@OneToMany(mappedBy="membresiaCliente")
	private List<MovimientoMembresia> movimientoMembresias;

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

	public List<MovimientoBeneficioMem> getMovimientoBeneficioMems() {
		return this.movimientoBeneficioMems;
	}

	public void setMovimientoBeneficioMems(List<MovimientoBeneficioMem> movimientoBeneficioMems) {
		this.movimientoBeneficioMems = movimientoBeneficioMems;
	}

	public MovimientoBeneficioMem addMovimientoBeneficioMem(MovimientoBeneficioMem movimientoBeneficioMem) {
		getMovimientoBeneficioMems().add(movimientoBeneficioMem);
		movimientoBeneficioMem.setMembresiaCliente(this);

		return movimientoBeneficioMem;
	}

	public MovimientoBeneficioMem removeMovimientoBeneficioMem(MovimientoBeneficioMem movimientoBeneficioMem) {
		getMovimientoBeneficioMems().remove(movimientoBeneficioMem);
		movimientoBeneficioMem.setMembresiaCliente(null);

		return movimientoBeneficioMem;
	}

	public List<MovimientoMembresia> getMovimientoMembresias() {
		return this.movimientoMembresias;
	}

	public void setMovimientoMembresias(List<MovimientoMembresia> movimientoMembresias) {
		this.movimientoMembresias = movimientoMembresias;
	}

	public MovimientoMembresia addMovimientoMembresia(MovimientoMembresia movimientoMembresia) {
		getMovimientoMembresias().add(movimientoMembresia);
		movimientoMembresia.setMembresiaCliente(this);

		return movimientoMembresia;
	}

	public MovimientoMembresia removeMovimientoMembresia(MovimientoMembresia movimientoMembresia) {
		getMovimientoMembresias().remove(movimientoMembresia);
		movimientoMembresia.setMembresiaCliente(null);

		return movimientoMembresia;
	}

}