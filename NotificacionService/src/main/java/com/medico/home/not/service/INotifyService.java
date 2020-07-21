/**
 * 
 */
package com.medico.home.not.service;

import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.persona.model.Persona;


/**
 * @author macpro
 *
 */
public interface INotifyService {

	String userTokenSubscribe(String usuario, String token, String origen);
	
	String sendNotificacionLlamadaEntrante(NotificacionVO userFrom);
	
	String sendNotificacionSingUp(Persona persona) throws Exception;
}
