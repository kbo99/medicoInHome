/**
 * 
 */
package com.medico.home.commons.cuestionario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author macpro
 *
 */
@Entity
public class ResCuest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3568359441152763606L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer rcuId;
	
	@Column
	private String rcuValor;
	
	@Column
	private Integer resId;
	
	@Column
	private Integer cueId;
	
	

	public ResCuest() {
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the rcuId
	 */
	public Integer getRcuId() {
		return rcuId;
	}

	/**
	 * @param rcuId the rcuId to set
	 */
	public void setRcuId(Integer rcuId) {
		this.rcuId = rcuId;
	}

	/**
	 * @return the rcuValor
	 */
	public String getRcuValor() {
		return rcuValor;
	}

	/**
	 * @param rcuValor the rcuValor to set
	 */
	public void setRcuValor(String rcuValor) {
		this.rcuValor = rcuValor;
	}

	/**
	 * @return the resId
	 */
	public Integer getResId() {
		return resId;
	}

	/**
	 * @param resId the resId to set
	 */
	public void setResId(Integer resId) {
		this.resId = resId;
	}

	/**
	 * @return the cueId
	 */
	public Integer getCueId() {
		return cueId;
	}

	/**
	 * @param cueId the cueId to set
	 */
	public void setCueId(Integer cueId) {
		this.cueId = cueId;
	}
	
	
	

}
