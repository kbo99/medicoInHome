package com.medico.home.not.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the notificacion_fcm database table.
 * 
 */
@Entity
@Table(name="notificacion_fcm")
@NamedQuery(name="NotificacionFcm.findAll", query="SELECT n FROM NotificacionFcm n")
public class NotificacionFcm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nfc_id")
	private int nfcId;

	@Column(name="nfc_dispositivo")
	private String nfcDispositivo;

	@Column(name="nfc_doctor")
	private String nfcDoctor;

	@Column(name="nfc_enllamada")
	private String nfcEnllamada;

	@Lob
	@Column(name="nfc_tkn_fcm")
	private String nfcTknFcm;

	@Column(name="usu_usuario")
	private String usuUsuario;
	
	@Transient
	private String titulo;

	@Transient
	private String mensaje;
	
	@Transient
	private String longitude;

	@Transient
	private String latitude;

	public NotificacionFcm() {
	}

	public int getNfcId() {
		return this.nfcId;
	}

	public void setNfcId(int nfcId) {
		this.nfcId = nfcId;
	}

	public String getNfcDispositivo() {
		return this.nfcDispositivo;
	}

	public void setNfcDispositivo(String nfcDispositivo) {
		this.nfcDispositivo = nfcDispositivo;
	}

	public String getNfcDoctor() {
		return this.nfcDoctor;
	}

	public void setNfcDoctor(String nfcDoctor) {
		this.nfcDoctor = nfcDoctor;
	}

	public String getNfcEnllamada() {
		return this.nfcEnllamada;
	}

	public void setNfcEnllamada(String nfcEnllamada) {
		this.nfcEnllamada = nfcEnllamada;
	}

	public String getNfcTknFcm() {
		return this.nfcTknFcm;
	}

	public void setNfcTknFcm(String nfcTknFcm) {
		this.nfcTknFcm = nfcTknFcm;
	}

	public String getUsuUsuario() {
		return this.usuUsuario;
	}

	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
	
	

}