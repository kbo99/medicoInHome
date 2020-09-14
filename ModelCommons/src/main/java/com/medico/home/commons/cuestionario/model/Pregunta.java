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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author macpro
 *
 */
@Entity
public class Pregunta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4260744453815595607L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer preId;
	
	@Column
	private String preTitle;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="sec_id")
	private Seccion seccion;
	
	@Column
	private Integer preOrden;
	
	@OneToMany(mappedBy="preguntaRe")
	private List<Respuesta> respuestas;
	
	/**
	 * @return the respuestas
	 */
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	/**
	 * @param respuestas the respuestas to set
	 */
	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Pregunta() {
		
	}

	/**
	 * @return the preId
	 */
	public Integer getPreId() {
		return preId;
	}

	/**
	 * @param preId the preId to set
	 */
	public void setPreId(Integer preId) {
		this.preId = preId;
	}

	/**
	 * @return the preTitle
	 */
	public String getPreTitle() {
		return preTitle;
	}

	/**
	 * @param preTitle the preTitle to set
	 */
	public void setPreTitle(String preTitle) {
		this.preTitle = preTitle;
	}


	/**
	 * @return the preOrden
	 */
	public Integer getPreOrden() {
		return preOrden;
	}

	/**
	 * @param preOrden the preOrden to set
	 */
	public void setPreOrden(Integer preOrden) {
		this.preOrden = preOrden;
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
	
	
	
	

}
