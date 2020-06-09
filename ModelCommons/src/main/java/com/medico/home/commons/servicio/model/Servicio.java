package com.medico.home.commons.servicio.model;

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

import com.medico.home.commons.consulta.model.ServicioConsulta;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ser_id")
	private int serId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ser_fecha_fin")
	private Date serFechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ser_fecha_inicio")
	private Date serFechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ser_horario_fin")
	private Date serHorarioFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ser_horario_in")
	private Date serHorarioIn;

	@Column(name="ser_observa")
	private String serObserva;

	//bi-directional many-to-one association to Hservicio
	@OneToMany(mappedBy="servicio")
	private List<Hservicio> hservicios;

	//bi-directional many-to-one association to ServicioEstatus
	@ManyToOne
	@JoinColumn(name="ses_id")
	private ServicioEstatus servicioEstatus;

	//bi-directional many-to-one association to TipoServicio
	@ManyToOne
	@JoinColumn(name="tps_id")
	private TipoServicio tipoServicio;

	//bi-directional many-to-one association to ServicioConsulta
	@OneToMany(mappedBy="servicio")
	private List<ServicioConsulta> servicioConsultas;

	//bi-directional many-to-one association to ServicioFarmacia
	@OneToMany(mappedBy="servicio")
	private List<ServicioFarmacia> servicioFarmacias;

	//bi-directional many-to-one association to ServicioPaciente
	@OneToMany(mappedBy="servicio")
	private List<ServicioPaciente> servicioPacientes;

	public Servicio() {
	}

	public int getSerId() {
		return this.serId;
	}

	public void setSerId(int serId) {
		this.serId = serId;
	}

	public Date getSerFechaFin() {
		return this.serFechaFin;
	}

	public void setSerFechaFin(Date serFechaFin) {
		this.serFechaFin = serFechaFin;
	}

	public Date getSerFechaInicio() {
		return this.serFechaInicio;
	}

	public void setSerFechaInicio(Date serFechaInicio) {
		this.serFechaInicio = serFechaInicio;
	}

	public Date getSerHorarioFin() {
		return this.serHorarioFin;
	}

	public void setSerHorarioFin(Date serHorarioFin) {
		this.serHorarioFin = serHorarioFin;
	}

	public Date getSerHorarioIn() {
		return this.serHorarioIn;
	}

	public void setSerHorarioIn(Date serHorarioIn) {
		this.serHorarioIn = serHorarioIn;
	}

	public String getSerObserva() {
		return this.serObserva;
	}

	public void setSerObserva(String serObserva) {
		this.serObserva = serObserva;
	}

	public List<Hservicio> getHservicios() {
		return this.hservicios;
	}

	public void setHservicios(List<Hservicio> hservicios) {
		this.hservicios = hservicios;
	}

	public Hservicio addHservicio(Hservicio hservicio) {
		getHservicios().add(hservicio);
		hservicio.setServicio(this);

		return hservicio;
	}

	public Hservicio removeHservicio(Hservicio hservicio) {
		getHservicios().remove(hservicio);
		hservicio.setServicio(null);

		return hservicio;
	}

	public ServicioEstatus getServicioEstatus() {
		return this.servicioEstatus;
	}

	public void setServicioEstatus(ServicioEstatus servicioEstatus) {
		this.servicioEstatus = servicioEstatus;
	}

	public TipoServicio getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public List<ServicioConsulta> getServicioConsultas() {
		return this.servicioConsultas;
	}

	public void setServicioConsultas(List<ServicioConsulta> servicioConsultas) {
		this.servicioConsultas = servicioConsultas;
	}


	public List<ServicioFarmacia> getServicioFarmacias() {
		return this.servicioFarmacias;
	}

	public void setServicioFarmacias(List<ServicioFarmacia> servicioFarmacias) {
		this.servicioFarmacias = servicioFarmacias;
	}

	public ServicioFarmacia addServicioFarmacia(ServicioFarmacia servicioFarmacia) {
		getServicioFarmacias().add(servicioFarmacia);
		servicioFarmacia.setServicio(this);

		return servicioFarmacia;
	}

	public ServicioFarmacia removeServicioFarmacia(ServicioFarmacia servicioFarmacia) {
		getServicioFarmacias().remove(servicioFarmacia);
		servicioFarmacia.setServicio(null);

		return servicioFarmacia;
	}

	public List<ServicioPaciente> getServicioPacientes() {
		return this.servicioPacientes;
	}

	public void setServicioPacientes(List<ServicioPaciente> servicioPacientes) {
		this.servicioPacientes = servicioPacientes;
	}

	public ServicioPaciente addServicioPaciente(ServicioPaciente servicioPaciente) {
		getServicioPacientes().add(servicioPaciente);
		servicioPaciente.setServicio(this);

		return servicioPaciente;
	}

	public ServicioPaciente removeServicioPaciente(ServicioPaciente servicioPaciente) {
		getServicioPacientes().remove(servicioPaciente);
		servicioPaciente.setServicio(null);

		return servicioPaciente;
	}

}