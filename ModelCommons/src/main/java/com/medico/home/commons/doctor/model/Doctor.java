package com.medico.home.commons.doctor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.medico.home.commons.consulta.model.Consulta;
import com.medico.home.commons.contacto.model.ContactoDoctor;
import com.medico.home.commons.persona.model.Persona;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doc_id")
	private int docId;

	@Column(name="doc_cedula")
	private String docCedula;

	@Column(name="doc_descripcion")
	private String docDescripcion;

	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="doctor")
	private List<Consulta> consultas;

	//bi-directional many-to-one association to ContactoDoctor
	@OneToMany(mappedBy="doctor")
	private List<ContactoDoctor> contactoDoctors;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_id")
	private Persona persona;

	//bi-directional many-to-one association to DoctorPacientePref
	@OneToMany(mappedBy="doctor")
	private List<DoctorPacientePref> doctorPacientePrefs;

	//bi-directional many-to-many association to Especialidad
	@ManyToMany(mappedBy="doctors")
	private List<Especialidad> especialidads;

	public Doctor() {
	}

	public int getDocId() {
		return this.docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocCedula() {
		return this.docCedula;
	}

	public void setDocCedula(String docCedula) {
		this.docCedula = docCedula;
	}

	public String getDocDescripcion() {
		return this.docDescripcion;
	}

	public void setDocDescripcion(String docDescripcion) {
		this.docDescripcion = docDescripcion;
	}

	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	

	public List<ContactoDoctor> getContactoDoctors() {
		return this.contactoDoctors;
	}

	public void setContactoDoctors(List<ContactoDoctor> contactoDoctors) {
		this.contactoDoctors = contactoDoctors;
	}

	public ContactoDoctor addContactoDoctor(ContactoDoctor contactoDoctor) {
		getContactoDoctors().add(contactoDoctor);
		contactoDoctor.setDoctor(this);

		return contactoDoctor;
	}

	public ContactoDoctor removeContactoDoctor(ContactoDoctor contactoDoctor) {
		getContactoDoctors().remove(contactoDoctor);
		contactoDoctor.setDoctor(null);

		return contactoDoctor;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<DoctorPacientePref> getDoctorPacientePrefs() {
		return this.doctorPacientePrefs;
	}

	public void setDoctorPacientePrefs(List<DoctorPacientePref> doctorPacientePrefs) {
		this.doctorPacientePrefs = doctorPacientePrefs;
	}

	public DoctorPacientePref addDoctorPacientePref(DoctorPacientePref doctorPacientePref) {
		getDoctorPacientePrefs().add(doctorPacientePref);
		doctorPacientePref.setDoctor(this);

		return doctorPacientePref;
	}

	public DoctorPacientePref removeDoctorPacientePref(DoctorPacientePref doctorPacientePref) {
		getDoctorPacientePrefs().remove(doctorPacientePref);
		doctorPacientePref.setDoctor(null);

		return doctorPacientePref;
	}

	public List<Especialidad> getEspecialidads() {
		return this.especialidads;
	}

	public void setEspecialidads(List<Especialidad> especialidads) {
		this.especialidads = especialidads;
	}

}