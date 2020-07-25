package com.medico.home.not.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medico_notificacion")
public class MedicoNotificacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048480315967588539L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer mnrId;
	
	@Column
	private String mnrUsu;
	
	@Column
	private String mnrDispon;
	
	public MedicoNotificacion() {
		
	}

	/**
	 * @return the mnrId
	 */
	public Integer getMnrId() {
		return mnrId;
	}

	/**
	 * @param mnrId the mnrId to set
	 */
	public void setMnrId(Integer mnrId) {
		this.mnrId = mnrId;
	}

	/**
	 * @return the mnrUsu
	 */
	public String getMnrUsu() {
		return mnrUsu;
	}

	/**
	 * @param mnrUsu the mnrUsu to set
	 */
	public void setMnrUsu(String mnrUsu) {
		this.mnrUsu = mnrUsu;
	}

	/**
	 * @return the mnrDispon
	 */
	public String getMnrDispon() {
		return mnrDispon;
	}

	/**
	 * @param mnrDispon the mnrDispon to set
	 */
	public void setMnrDispon(String mnrDispon) {
		this.mnrDispon = mnrDispon;
	}
	
	

}
