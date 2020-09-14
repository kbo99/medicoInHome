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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author macpro
 *
 */
@Entity
public class TipoSecc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5398778283673047036L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer tpsId;
	
	@ManyToOne
	@JoinColumn(name="sec_id")
	private Seccion seccion;
	
	@Column
	private Integer tpcId;
	
	@Column
	private Integer tpsOrden;
	
	public TipoSecc() {
		
	}

	/**
	 * @return the tpsId
	 */
	public Integer getTpsId() {
		return tpsId;
	}

	/**
	 * @param tpsId the tpsId to set
	 */
	public void setTpsId(Integer tpsId) {
		this.tpsId = tpsId;
	}

	/**
	 * @return the seccion
	 */
	public Seccion getSeccion() {
		return seccion;
	}

	/**
	 * @param seccion the seccion to set
	 */
	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
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
	 * @return the tpsOrden
	 */
	public Integer getTpsOrden() {
		return tpsOrden;
	}

	/**
	 * @param tpsOrden the tpsOrden to set
	 */
	public void setTpsOrden(Integer tpsOrden) {
		this.tpsOrden = tpsOrden;
	}
	
	


}
