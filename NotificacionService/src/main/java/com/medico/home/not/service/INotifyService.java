/**
 * 
 */
package com.medico.home.not.service;

import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.not.model.MedicoNotificacion;


/**
 * @author macpro
 *
 */
public interface INotifyService {

	String userTokenSubscribe(String usuario, String token);
	
	String sendNotificacionLlamadaEntrante(String userFrom);
	
	String sendNotificacionSingUp(Usuario persona) throws Exception;
	
	String medicoNotifyAdd(MedicoNotificacion mediNot) throws Exception;
}
