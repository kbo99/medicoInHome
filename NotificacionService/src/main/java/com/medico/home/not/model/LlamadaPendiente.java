/**
 * 
 */
package com.medico.home.not.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author macpro
 *
 */
@Entity
@Table
public class LlamadaPendiente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7960584230760584823L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long llpId;
	
	
	@Column
	private String 	usuSol;
	
	@Column
	private String llpEstatus;
	
	@Column
	private Date llpFecha;
	
	
	@Column
	private String llpAtendida;
	
	@Transient
	private String tknAgora;
	
	
	public LlamadaPendiente() {
		
	}


	/**
	 * @return the llpId
	 */
	public Long getLlpId() {
		return llpId;
	}


	/**
	 * @param llpId the llpId to set
	 */
	public void setLlpId(Long llpId) {
		this.llpId = llpId;
	}


	/**
	 * @return the usuSol
	 */
	public String getUsuSol() {
		return usuSol;
	}


	/**
	 * @param usuSol the usuSol to set
	 */
	public void setUsuSol(String usuSol) {
		this.usuSol = usuSol;
	}


	/**
	 * @return the llpEstatus
	 */
	public String getLlpEstatus() {
		return llpEstatus;
	}


	/**
	 * @param llpEstatus the llpEstatus to set
	 */
	public void setLlpEstatus(String llpEstatus) {
		this.llpEstatus = llpEstatus;
	}


	/**
	 * @return the llpFecha
	 */
	public Date getLlpFecha() {
		return llpFecha;
	}


	/**
	 * @param llpFecha the llpFecha to set
	 */
	public void setLlpFecha(Date llpFecha) {
		this.llpFecha = llpFecha;
	}


	/**
	 * @return the llpAtendida
	 */
	public String getLlpAtendida() {
		return llpAtendida;
	}


	/**
	 * @param llpAtendida the llpAtendida to set
	 */
	public void setLlpAtendida(String llpAtendida) {
		this.llpAtendida = llpAtendida;
	}


	/**
	 * @return the tknAgora
	 */
	public String getTknAgora() {
		return tknAgora;
	}


	/**
	 * @param tknAgora the tknAgora to set
	 */
	public void setTknAgora(String tknAgora) {
		this.tknAgora = tknAgora;
	}
	
	
	

}
