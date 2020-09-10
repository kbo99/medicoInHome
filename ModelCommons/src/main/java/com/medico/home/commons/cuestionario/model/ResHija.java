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
import javax.persistence.OneToOne;

/**
 * @author macpro
 *
 */
@Entity
public class ResHija implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6051588867636408626L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer rehId;
	
	@OneToOne
	@JoinColumn(name="pre_id")
	private Pregunta pregunta;
	
	@OneToOne
	@JoinColumn(name="res_id")
	private Respuesta respuesta;

	public ResHija() {
		
	}

	/**
	 * @return the rehId
	 */
	public Integer getRehId() {
		return rehId;
	}

	/**
	 * @param rehId the rehId to set
	 */
	public void setRehId(Integer rehId) {
		this.rehId = rehId;
	}

	/**
	 * @return the pregunta
	 */
	public Pregunta getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the respuesta
	 */
	public Respuesta getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
	
	
	
	

}
