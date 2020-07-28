/**
 * 
 */
package com.medico.home.sender.vo;

import java.io.Serializable;

/**
 * @author macpro
 *
 */
public class NotificacionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3104820395064315894L;
	
	
	private String mensaje;
	
	private String destination;
	
	private String topicDestino;
	
	private String nombreNotificacion;
	
	private String accion;
	
	private String idLlamada;
	
	private String sendToUser;
	
	private String sendFromUser;
	
	private String angoraString;
	
	
	public NotificacionVO() {
		
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the topicDestino
	 */
	public String getTopicDestino() {
		return topicDestino;
	}

	/**
	 * @param topicDestino the topicDestino to set
	 */
	public void setTopicDestino(String topicDestino) {
		this.topicDestino = topicDestino;
	}

	/**
	 * @return the nombreNotificacion
	 */
	public String getNombreNotificacion() {
		return nombreNotificacion;
	}

	/**
	 * @param nombreNotificacion the nombreNotificacion to set
	 */
	public void setNombreNotificacion(String nombreNotificacion) {
		this.nombreNotificacion = nombreNotificacion;
	}

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	/**
	 * @return the idLlamada
	 */
	public String getIdLlamada() {
		return idLlamada;
	}

	/**
	 * @param idLlamada the idLlamada to set
	 */
	public void setIdLlamada(String idLlamada) {
		this.idLlamada = idLlamada;
	}

	/**
	 * @return the sendToUser
	 */
	public String getSendToUser() {
		return sendToUser;
	}

	/**
	 * @param sendToUser the sendToUser to set
	 */
	public void setSendToUser(String sendToUser) {
		this.sendToUser = sendToUser;
	}

	/**
	 * @return the sendFromUser
	 */
	public String getSendFromUser() {
		return sendFromUser;
	}

	/**
	 * @param sendFromUser the sendFromUser to set
	 */
	public void setSendFromUser(String sendFromUser) {
		this.sendFromUser = sendFromUser;
	}

	/**
	 * @return the angoraString
	 */
	public String getAngoraString() {
		return angoraString;
	}

	/**
	 * @param angoraString the angoraString to set
	 */
	public void setAngoraString(String angoraString) {
		this.angoraString = angoraString;
	}
	
	
	
	
}
