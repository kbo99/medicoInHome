/**
 * 
 */
package com.medico.home.commons.cuestionario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author macpro
 *
 */
@Entity
public class Respuesta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4062977580242178793L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer resId;
	
	@Column
	private String resTitle;
	
	@Column
	private Integer resTipoComp;
	
	@Column
	private String resMulti;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="pre_id")
	private Pregunta preguntaRe;
	
	@Column
	private Integer resOrden;
	
	@Transient
	private List<ResCuest> contesto;
	
	@Transient
	private List<Pregunta> pregunta;
	
	@Transient
	private Boolean resSelec;
	
	@Transient
	private Boolean resHabilitaChild;
	
	@Transient
	private String resValorTmp;

	public Respuesta() {
		
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
	 * @return the resTitle
	 */
	public String getResTitle() {
		return resTitle;
	}

	/**
	 * @param resTitle the resTitle to set
	 */
	public void setResTitle(String resTitle) {
		this.resTitle = resTitle;
	}

	/**
	 * @return the resTipoComp
	 */
	public Integer getResTipoComp() {
		return resTipoComp;
	}

	/**
	 * @param resTipoComp the resTipoComp to set
	 */
	public void setResTipoComp(Integer resTipoComp) {
		this.resTipoComp = resTipoComp;
	}

	/**
	 * @return the pregunta
	 */
	public Pregunta getPreguntaRe() {
		return preguntaRe;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPreguntaRe(Pregunta pregunta) {
		this.preguntaRe = pregunta;
	}

	/**
	 * @return the resOrden
	 */
	public Integer getResOrden() {
		return resOrden;
	}

	/**
	 * @param resOrden the resOrden to set
	 */
	public void setResOrden(Integer resOrden) {
		this.resOrden = resOrden;
	}

	/**
	 * @return the resMulti
	 */
	public String getResMulti() {
		return resMulti;
	}

	/**
	 * @param resMulti the resMulti to set
	 */
	public void setResMulti(String resMulti) {
		this.resMulti = resMulti;
	}

	/**
	 * @return the contesto
	 */
	public List<ResCuest> getContesto() {
		return contesto == null ? new ArrayList<ResCuest>() : contesto;
	}

	/**
	 * @param contesto the contesto to set
	 */
	public void setContesto(List<ResCuest> contesto) {
		this.contesto = contesto;
	}

	/**
	 * @return the pregunta
	 */
	public List<Pregunta> getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(List<Pregunta> pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the resSelec
	 */
	public Boolean getResSelec() {
		return resSelec;
	}

	/**
	 * @param resSelec the resSelec to set
	 */
	public void setResSelec(Boolean resSelec) {
		this.resSelec = resSelec;
	}

	/**
	 * @return the resHabilitaChild
	 */
	public Boolean getResHabilitaChild() {
		return resHabilitaChild;
	}

	/**
	 * @param resHabilitaChild the resHabilitaChild to set
	 */
	public void setResHabilitaChild(Boolean resHabilitaChild) {
		this.resHabilitaChild = resHabilitaChild;
	}

	/**
	 * @return the resValorTmp
	 */
	public String getResValorTmp() {
		return resValorTmp;
	}

	/**
	 * @param resValorTmp the resValorTmp to set
	 */
	public void setResValorTmp(String resValorTmp) {
		this.resValorTmp = resValorTmp;
	}
	
	
	
	
	
	
	
	
	
	

}
