/**
 * 
 */
package com.medico.home.not.service;

import java.util.List;

import com.medico.home.not.model.MedicoLlamada;
import com.medico.home.not.model.NotificacionFcm;

/**
 * @author macpro
 *
 */
public interface INotificacionFCM {
	
	public NotificacionFcm actualizaToken(NotificacionFcm notifica);
	
	public List<NotificacionFcm> findTknDoctorUrgencia(NotificacionFcm user, 
			String tpoAtiende, String enLlamada);
	
	public List<String> findTknDoctorAsignado(List<Integer> lstDoc);
	
	public NotificacionFcm generaNotificaLlamada(NotificacionFcm user);
	
	public MedicoLlamada guardaDetalleLlamada(MedicoLlamada medico);

}
