/**
 * 
 */
package com.medico.home.not.service;

import java.util.List;

import com.medico.home.not.model.NotificacionFcm;

/**
 * @author macpro
 *
 */
public interface INotificacionFCM {
	
	public NotificacionFcm actualizaToken(NotificacionFcm notifica);
	
	public List<NotificacionFcm> findTknDoctorUrgencia(NotificacionFcm user);
	
	public List<String> findTknDoctorAsignado(List<Integer> lstDoc);

}
