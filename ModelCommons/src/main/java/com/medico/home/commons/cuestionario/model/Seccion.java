/**
 * 
 */
package com.medico.home.commons.cuestionario.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author macpro
 *
 */
@Entity
public class Seccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1718934483394611329L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer secId;
	
	@Column
	private String secTitle;
	
	@Column
	private String secDesc;
	
	@OneToMany(mappedBy="seccion")
	private List<Pregunta> preguntas;
	
	/**
	 * @return the preguntas
	 */
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Seccion() {
		
	}

	/**
	 * @return the secId
	 */
	public Integer getSecId() {
		return secId;
	}

	/**
	 * @param secId the secId to set
	 */
	public void setSecId(Integer secId) {
		this.secId = secId;
	}

	/**
	 * @return the secTitle
	 */
	public String getSecTitle() {
		return secTitle;
	}

	/**
	 * @param secTitle the secTitle to set
	 */
	public void setSecTitle(String secTitle) {
		this.secTitle = secTitle;
	}

	/**
	 * @return the secDesc
	 */
	public String getSecDesc() {
		return secDesc;
	}

	/**
	 * @param secDesc the secDesc to set
	 */
	public void setSecDesc(String secDesc) {
		this.secDesc = secDesc;
	}
	
	
	
}
