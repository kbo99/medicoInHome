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

/**
 * @author macpro
 *
 */
@Entity
public class Notificacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 669383159041442327L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long notId;
	
	@Column
	private Date notFecha;
	
	@Column
	private Date notFechaVisto;
	
	@Column
	private String usuario;
	
	@Column
	private String notVisto;
	
	@Column
	private String notVieneVamos;
	
	@Column
	private String notContenido;
	
	@Column
	private String notToken;
	
	@Column
	private String notTipo;
	
	public Notificacion() {
		
	}

	/**
	 * @return the notId
	 */
	public Long getNotId() {
		return notId;
	}

	/**
	 * @param notId the notId to set
	 */
	public void setNotId(Long notId) {
		this.notId = notId;
	}

	/**
	 * @return the notFecha
	 */
	public Date getNotFecha() {
		return notFecha;
	}

	/**
	 * @param notFecha the notFecha to set
	 */
	public void setNotFecha(Date notFecha) {
		this.notFecha = notFecha;
	}

	/**
	 * @return the notFechaVisto
	 */
	public Date getNotFechaVisto() {
		return notFechaVisto;
	}

	/**
	 * @param notFechaVisto the notFechaVisto to set
	 */
	public void setNotFechaVisto(Date notFechaVisto) {
		this.notFechaVisto = notFechaVisto;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the notVisto
	 */
	public String getNotVisto() {
		return notVisto;
	}

	/**
	 * @param notVisto the notVisto to set
	 */
	public void setNotVisto(String notVisto) {
		this.notVisto = notVisto;
	}

	/**
	 * @return the notVieneVamos
	 */
	public String getNotVieneVamos() {
		return notVieneVamos;
	}

	/**
	 * @param notVieneVamos the notVieneVamos to set
	 */
	public void setNotVieneVamos(String notVieneVamos) {
		this.notVieneVamos = notVieneVamos;
	}

	/**
	 * @return the notContenido
	 */
	public String getNotContenido() {
		return notContenido;
	}

	/**
	 * @param notContenido the notContenido to set
	 */
	public void setNotContenido(String notContenido) {
		this.notContenido = notContenido;
	}

	/**
	 * @return the notToken
	 */
	public String getNotToken() {
		return notToken;
	}

	/**
	 * @param notToken the notToken to set
	 */
	public void setNotToken(String notToken) {
		this.notToken = notToken;
	}

	/**
	 * @return the notTipo
	 */
	public String getNotTipo() {
		return notTipo;
	}

	/**
	 * @param notTipo the notTipo to set
	 */
	public void setNotTipo(String notTipo) {
		this.notTipo = notTipo;
	}
	
	

}
