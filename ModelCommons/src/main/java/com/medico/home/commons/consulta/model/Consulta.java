package com.medico.home.commons.consulta.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.medico.home.commons.doctor.model.Doctor;
import com.medico.home.commons.doctor.model.Paciente;


/**
 * The persistent class for the consulta database table.
 * 
 */
@Entity
@NamedQuery(name="Consulta.findAll", query="SELECT c FROM Consulta c")
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="con_id")
	private int conId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="con_fecha_consulta")
	private Date conFechaConsulta;

	@Temporal(TemporalType.DATE)
	@Column(name="con_fregsitro")
	private Date conFregsitro;

	@Column(name="con_pac_edad")
	private int conPacEdad;

	@Column(name="con_pac_estatura")
	private BigDecimal conPacEstatura;

	@Column(name="con_pac_peso")
	private BigDecimal conPacPeso;

	@Column(name="usu_registra")
	private String usuRegistra;

	//bi-directional many-to-one association to ConsultaEstatus
	@ManyToOne
	@JoinColumn(name="coe_id")
	private ConsultaEstatus consultaEstatus;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="doc_id")
	private Doctor doctor;

	//bi-directional many-to-one association to MedioConsulta
	@ManyToOne
	@JoinColumn(name="mec_id")
	private MedioConsulta medioConsulta;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="pac_id")
	private Paciente paciente;

	//bi-directional many-to-one association to DiagnosticoConsulta
	@OneToMany(mappedBy="consulta")
	private List<DiagnosticoConsulta> diagnosticoConsultas;

	//bi-directional many-to-one association to RecetaConsulta
	@OneToMany(mappedBy="consulta")
	private List<RecetaConsulta> recetaConsultas;

	//bi-directional many-to-one association to ServicioConsulta
	@OneToMany(mappedBy="consulta")
	private List<ServicioConsulta> servicioConsultas;

	public Consulta() {
	}

	public int getConId() {
		return this.conId;
	}

	public void setConId(int conId) {
		this.conId = conId;
	}

	public Date getConFechaConsulta() {
		return this.conFechaConsulta;
	}

	public void setConFechaConsulta(Date conFechaConsulta) {
		this.conFechaConsulta = conFechaConsulta;
	}

	public Date getConFregsitro() {
		return this.conFregsitro;
	}

	public void setConFregsitro(Date conFregsitro) {
		this.conFregsitro = conFregsitro;
	}

	public int getConPacEdad() {
		return this.conPacEdad;
	}

	public void setConPacEdad(int conPacEdad) {
		this.conPacEdad = conPacEdad;
	}

	public BigDecimal getConPacEstatura() {
		return this.conPacEstatura;
	}

	public void setConPacEstatura(BigDecimal conPacEstatura) {
		this.conPacEstatura = conPacEstatura;
	}

	public BigDecimal getConPacPeso() {
		return this.conPacPeso;
	}

	public void setConPacPeso(BigDecimal conPacPeso) {
		this.conPacPeso = conPacPeso;
	}

	public String getUsuRegistra() {
		return this.usuRegistra;
	}

	public void setUsuRegistra(String usuRegistra) {
		this.usuRegistra = usuRegistra;
	}

	public ConsultaEstatus getConsultaEstatus() {
		return this.consultaEstatus;
	}

	public void setConsultaEstatus(ConsultaEstatus consultaEstatus) {
		this.consultaEstatus = consultaEstatus;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public MedioConsulta getMedioConsulta() {
		return this.medioConsulta;
	}

	public void setMedioConsulta(MedioConsulta medioConsulta) {
		this.medioConsulta = medioConsulta;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<DiagnosticoConsulta> getDiagnosticoConsultas() {
		return this.diagnosticoConsultas;
	}

	public void setDiagnosticoConsultas(List<DiagnosticoConsulta> diagnosticoConsultas) {
		this.diagnosticoConsultas = diagnosticoConsultas;
	}

	public DiagnosticoConsulta addDiagnosticoConsulta(DiagnosticoConsulta diagnosticoConsulta) {
		getDiagnosticoConsultas().add(diagnosticoConsulta);
		diagnosticoConsulta.setConsulta(this);

		return diagnosticoConsulta;
	}

	public DiagnosticoConsulta removeDiagnosticoConsulta(DiagnosticoConsulta diagnosticoConsulta) {
		getDiagnosticoConsultas().remove(diagnosticoConsulta);
		diagnosticoConsulta.setConsulta(null);

		return diagnosticoConsulta;
	}

	public List<RecetaConsulta> getRecetaConsultas() {
		return this.recetaConsultas;
	}

	public void setRecetaConsultas(List<RecetaConsulta> recetaConsultas) {
		this.recetaConsultas = recetaConsultas;
	}

	public RecetaConsulta addRecetaConsulta(RecetaConsulta recetaConsulta) {
		getRecetaConsultas().add(recetaConsulta);
		recetaConsulta.setConsulta(this);

		return recetaConsulta;
	}

	public RecetaConsulta removeRecetaConsulta(RecetaConsulta recetaConsulta) {
		getRecetaConsultas().remove(recetaConsulta);
		recetaConsulta.setConsulta(null);

		return recetaConsulta;
	}

	public List<ServicioConsulta> getServicioConsultas() {
		return this.servicioConsultas;
	}

	public void setServicioConsultas(List<ServicioConsulta> servicioConsultas) {
		this.servicioConsultas = servicioConsultas;
	}

	public ServicioConsulta addServicioConsulta(ServicioConsulta servicioConsulta) {
		getServicioConsultas().add(servicioConsulta);
		servicioConsulta.setConsulta(this);

		return servicioConsulta;
	}

	public ServicioConsulta removeServicioConsulta(ServicioConsulta servicioConsulta) {
		getServicioConsultas().remove(servicioConsulta);
		servicioConsulta.setConsulta(null);

		return servicioConsulta;
	}

}