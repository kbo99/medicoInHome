/**
 * 
 */
package com.medico.home.commons.cuestionario.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author macpro
 *
 */
@Entity
public class TipoCuest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7335474325275461323L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer tpcId;
	
	@Column
	private String tpcNombre;
	
	@Column
	private String tpcEstatus;
	
	@Column
	private Date tpcFcracion;
	
	@Column
	private Date tpcFmodif;
	
	@Transient
	private List<Seccion> secciones;

	public TipoCuest() {
		
	}

	/**
	 * @return the tpcId
	 */
	public Integer getTpcId() {
		return tpcId;
	}

	/**
	 * @param tpcId the tpcId to set
	 */
	public void setTpcId(Integer tpcId) {
		this.tpcId = tpcId;
	}

	/**
	 * @return the tpcNombre
	 */
	public String getTpcNombre() {
		return tpcNombre;
	}

	/**
	 * @param tpcNombre the tpcNombre to set
	 */
	public void setTpcNombre(String tpcNombre) {
		this.tpcNombre = tpcNombre;
	}

	/**
	 * @return the tpcEstatus
	 */
	public String getTpcEstatus() {
		return tpcEstatus;
	}

	/**
	 * @param tpcEstatus the tpcEstatus to set
	 */
	public void setTpcEstatus(String tpcEstatus) {
		this.tpcEstatus = tpcEstatus;
	}

	/**
	 * @return the tpcFcracion
	 */
	public Date getTpcFcracion() {
		return tpcFcracion;
	}

	/**
	 * @param tpcFcracion the tpcFcracion to set
	 */
	public void setTpcFcracion(Date tpcFcracion) {
		this.tpcFcracion = tpcFcracion;
	}

	/**
	 * @return the tpcFmodif
	 */
	public Date getTpcFmodif() {
		return tpcFmodif;
	}

	/**
	 * @param tpcFmodif the tpcFmodif to set
	 */
	public void setTpcFmodif(Date tpcFmodif) {
		this.tpcFmodif = tpcFmodif;
	}

	/**
	 * @return the secciones
	 */
	public List<Seccion> getSecciones() {
		return secciones;
	}

	/**
	 * @param secciones the secciones to set
	 */
	public void setSecciones(List<Seccion> secciones) {
		this.secciones = secciones;
	}
	
	

}
