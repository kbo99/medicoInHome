package com.medico.home.commons.doctor.model;

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

import com.medico.home.commons.cliente.model.ClientePersona;
import com.medico.home.commons.consulta.model.Consulta;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pac_id")
	private int pacId;

	@Temporal(TemporalType.DATE)
	@Column(name="pac_fnacimiento")
	private Date pacFnacimiento;

	@Column(name="pac_sexo")
	private String pacSexo;

	@Column(name="pac_tpo_sangre")
	private String pacTpoSangre;

	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="paciente")
	private List<DoctorPacientePref> doctorPacientePrefs;

	//bi-directional many-to-one association to ClientePersona
//	@ManyToOne
//	@JoinColumn(name="cpe_id")
//	private ClientePersona clientePersona;

	

	public Paciente() {
	}

	public int getPacId() {
		return this.pacId;
	}

	public void setPacId(int pacId) {
		this.pacId = pacId;
	}

	public Date getPacFnacimiento() {
		return this.pacFnacimiento;
	}

	public void setPacFnacimiento(Date pacFnacimiento) {
		this.pacFnacimiento = pacFnacimiento;
	}

	public String getPacSexo() {
		return this.pacSexo;
	}

	public void setPacSexo(String pacSexo) {
		this.pacSexo = pacSexo;
	}

	public String getPacTpoSangre() {
		return this.pacTpoSangre;
	}

	public void setPacTpoSangre(String pacTpoSangre) {
		this.pacTpoSangre = pacTpoSangre;
	}
//
//	public List<Consulta> getConsultas() {
//		return this.consultas;
//	}
//
//	public void setConsultas(List<Consulta> consultas) {
//		this.consultas = consultas;
//	}



	public List<DoctorPacientePref> getDoctorPacientePrefs() {
		return this.doctorPacientePrefs;
	}

	public void setDoctorPacientePrefs(List<DoctorPacientePref> doctorPacientePrefs) {
		this.doctorPacientePrefs = doctorPacientePrefs;
	}

	public DoctorPacientePref addDoctorPacientePref(DoctorPacientePref doctorPacientePref) {
		getDoctorPacientePrefs().add(doctorPacientePref);
		doctorPacientePref.setPaciente(this);

		return doctorPacientePref;
	}

	public DoctorPacientePref removeDoctorPacientePref(DoctorPacientePref doctorPacientePref) {
		getDoctorPacientePrefs().remove(doctorPacientePref);
		doctorPacientePref.setPaciente(null);

		return doctorPacientePref;
	}

//	public ClientePersona getClientePersona() {
//		return this.clientePersona;
//	}
//
//	public void setClientePersona(ClientePersona clientePersona) {
//		this.clientePersona = clientePersona;
//	}

	
}