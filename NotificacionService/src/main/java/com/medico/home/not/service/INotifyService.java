/**
 * 
 */
package com.medico.home.not.service;

import java.util.List;
import java.util.Map;

import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.not.model.LlamadaPendiente;
import com.medico.home.not.model.MedicoLlamada;
import com.medico.home.not.model.MedicoNotificacion;
import com.medico.home.not.model.NotificacionFcm;


/**
 * @author macpro
 *
 */
public interface INotifyService {

	String userTokenSubscribe(String usuario, String token);
	
	LlamadaPendiente sendNotificacionLlamadaEntrante(String userFrom);
	
	String sendNotificacionSingUp(Usuario persona) throws Exception;
	
	String medicoNotifyAdd(MedicoNotificacion mediNot) throws Exception;
	
	LlamadaPendiente buscaAtiendeLlamadaPendiente(String medicoId,Map<String, String> mapConfig)throws Exception;
	
	NotificacionVO atiendeLlamada(NotificacionVO medico) throws Exception;
	
	LlamadaPendiente finalizaLlamada(String userSol)throws Exception;
	
	String getSktCnt()throws Exception;
	
	LlamadaPendiente atiendeOperador(NotificacionFcm llamadaId)throws Exception;
	
}
