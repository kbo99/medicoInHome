/**
 * 
 */
package com.medico.home.not.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author macpro
 *
 */
@Entity
public class Token implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8261803117662548809L;

	@Id
	@Column
	private String usuario;
	
	@Column
	private String token;
	
	@Column
	private Date tknFecha;
	
	@Column
	private String tknOrigen;
	
	/**
	 * @return the tknOrigen
	 */
	public String getTknOrigen() {
		return tknOrigen;
	}

	/**
	 * @param tknOrigen the tknOrigen to set
	 */
	public void setTknOrigen(String tknOrigen) {
		this.tknOrigen = tknOrigen;
	}

	public Token () {
		
	}
	
	public Token (String usuario, String token, String tknOrigen) {
		this.usuario = usuario;
		this.token = token;
		this.tknOrigen = tknOrigen;
		this.tknFecha = new Date();
		
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the tknFecha
	 */
	public Date getTknFecha() {
		return tknFecha;
	}

	/**
	 * @param tknFecha the tknFecha to set
	 */
	public void setTknFecha(Date tknFecha) {
		this.tknFecha = tknFecha;
	}
	
	
	
	

}
