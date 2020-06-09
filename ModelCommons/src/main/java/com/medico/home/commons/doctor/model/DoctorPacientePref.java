package com.medico.home.commons.doctor.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the doctor_paciente_pref database table.
 * 
 */
@Entity
@Table(name="doctor_paciente_pref")
@NamedQuery(name="DoctorPacientePref.findAll", query="SELECT d FROM DoctorPacientePref d")
public class DoctorPacientePref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dpp_id")
	private int dppId;

	@Column(name="dpp_activo")
	private String dppActivo;

	@Temporal(TemporalType.DATE)
	@Column(name="dpp_fregistro")
	private Date dppFregistro;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="doc_id")
	private Doctor doctor;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="pac_id")
	private Paciente paciente;

	public DoctorPacientePref() {
	}

	public int getDppId() {
		return this.dppId;
	}

	public void setDppId(int dppId) {
		this.dppId = dppId;
	}

	public String getDppActivo() {
		return this.dppActivo;
	}

	public void setDppActivo(String dppActivo) {
		this.dppActivo = dppActivo;
	}

	public Date getDppFregistro() {
		return this.dppFregistro;
	}

	public void setDppFregistro(Date dppFregistro) {
		this.dppFregistro = dppFregistro;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}