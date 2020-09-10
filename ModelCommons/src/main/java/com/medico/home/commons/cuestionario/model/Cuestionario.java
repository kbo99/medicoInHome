/**
 * 
 */
package com.medico.home.commons.cuestionario.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.medico.home.commons.cliente.model.ClientePersona;

/**
 * @author macpro
 *
 */
@Entity
public class Cuestionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7008327023786271301L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer cueId;
	
	@OneToOne
	@JoinColumn(name="tpc_id")
	private TipoCuest tipoCuest;
	
	@OneToOne
	@JoinColumn(name="cpe_id")
	private ClientePersona clientePersona;
	
	@Column
	private Date cueFecha;
	
	@Column
	private String cueEstatus;
	
	

	public Cuestionario() {
	
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

	/**
	 * @return the tipoCuest
	 */
	public TipoCuest getTipoCuest() {
		return tipoCuest;
	}

	/**
	 * @param tipoCuest the tipoCuest to set
	 */
	public void setTipoCuest(TipoCuest tipoCuest) {
		this.tipoCuest = tipoCuest;
	}

	/**
	 * @return the clientePersona
	 */
	public ClientePersona getClientePersona() {
		return clientePersona;
	}

	/**
	 * @param clientePersona the clientePersona to set
	 */
	public void setClientePersona(ClientePersona clientePersona) {
		this.clientePersona = clientePersona;
	}

	/**
	 * @return the cueFecha
	 */
	public Date getCueFecha() {
		return cueFecha;
	}

	/**
	 * @param cueFecha the cueFecha to set
	 */
	public void setCueFecha(Date cueFecha) {
		this.cueFecha = cueFecha;
	}

	/**
	 * @return the cueEstatus
	 */
	public String getCueEstatus() {
		return cueEstatus;
	}

	/**
	 * @param cueEstatus the cueEstatus to set
	 */
	public void setCueEstatus(String cueEstatus) {
		this.cueEstatus = cueEstatus;
	} 
	
	
	
	

}
