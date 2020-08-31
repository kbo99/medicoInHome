/**
 * 
 */
package com.medico.home.not.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author macpro
 *
 */
@Entity
@Table(name = "parametro")
public class Parametro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5196969425965878247L;
	
	@Id
	@Column
	private String prnId;
	
	@Column
	private String prnValor;
	
	@Column
	private String prnDescripcion;
	
	public Parametro() {
		
	}

	/**
	 * @return the prnId
	 */
	public String getPrnId() {
		return prnId;
	}

	/**
	 * @param prnId the prnId to set
	 */
	public void setPrnId(String prnId) {
		this.prnId = prnId;
	}

	/**
	 * @return the prnValor
	 */
	public String getPrnValor() {
		return prnValor;
	}

	/**
	 * @param prnValor the prnValor to set
	 */
	public void setPrnValor(String prnValor) {
		this.prnValor = prnValor;
	}

	/**
	 * @return the prnDescripcion
	 */
	public String getPrnDescripcion() {
		return prnDescripcion;
	}

	/**
	 * @param prnDescripcion the prnDescripcion to set
	 */
	public void setPrnDescripcion(String prnDescripcion) {
		this.prnDescripcion = prnDescripcion;
	}
	
	
	

}
