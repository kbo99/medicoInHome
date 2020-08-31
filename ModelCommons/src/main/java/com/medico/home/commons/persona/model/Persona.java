package com.medico.home.commons.persona.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="per_id")
	private int perId;

	@Column(name="per_ape_mat")
	private String perApeMat;

	@Column(name="per_ape_pate")
	private String perApePate;

	@Column(name="per_email")
	private String perEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="per_falta")
	private Date perFalta;

	@Temporal(TemporalType.DATE)
	@Column(name="per_fnacimiento")
	private Date perFnacimiento;

	@Column(name="per_nombre")
	private String perNombre;

	@Column(name="per_rfc")
	private String perRfc;
	
	@Column(name="per_telefono")
	private String perTelefono;
	
	@Transient
	private String password;
	
	@Transient
	private Integer membresia;

	/**
	 * @return the perId
	 */
	public int getPerId() {
		return perId;
	}

	/**
	 * @param perId the perId to set
	 */
	public void setPerId(int perId) {
		this.perId = perId;
	}

	/**
	 * @return the perApeMat
	 */
	public String getPerApeMat() {
		return perApeMat;
	}

	/**
	 * @param perApeMat the perApeMat to set
	 */
	public void setPerApeMat(String perApeMat) {
		this.perApeMat = perApeMat;
	}

	/**
	 * @return the perApePate
	 */
	public String getPerApePate() {
		return perApePate;
	}

	/**
	 * @param perApePate the perApePate to set
	 */
	public void setPerApePate(String perApePate) {
		this.perApePate = perApePate;
	}

	/**
	 * @return the perEmail
	 */
	public String getPerEmail() {
		return perEmail;
	}

	/**
	 * @param perEmail the perEmail to set
	 */
	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	/**
	 * @return the perFalta
	 */
	public Date getPerFalta() {
		return perFalta;
	}

	/**
	 * @param perFalta the perFalta to set
	 */
	public void setPerFalta(Date perFalta) {
		this.perFalta = perFalta;
	}

	/**
	 * @return the perFnacimiento
	 */
	public Date getPerFnacimiento() {
		return perFnacimiento;
	}

	/**
	 * @param perFnacimiento the perFnacimiento to set
	 */
	public void setPerFnacimiento(Date perFnacimiento) {
		this.perFnacimiento = perFnacimiento;
	}

	/**
	 * @return the perNombre
	 */
	public String getPerNombre() {
		return perNombre;
	}

	/**
	 * @param perNombre the perNombre to set
	 */
	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	/**
	 * @return the perRfc
	 */
	public String getPerRfc() {
		return perRfc;
	}

	/**
	 * @param perRfc the perRfc to set
	 */
	public void setPerRfc(String perRfc) {
		this.perRfc = perRfc;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the perTelefono
	 */
	public String getPerTelefono() {
		return perTelefono;
	}

	/**
	 * @param perTelefono the perTelefono to set
	 */
	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

	/**
	 * @return the membresia
	 */
	public Integer getMembresia() {
		return membresia;
	}

	/**
	 * @param membresia the membresia to set
	 */
	public void setMembresia(Integer membresia) {
		this.membresia = membresia;
	}
	
	
	
	

	

}