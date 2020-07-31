/**
 * 
 */
package com.medico.home.not.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.not.model.LlamadaPendiente;
import com.medico.home.not.model.Token;
import com.medico.home.not.service.INotifyService;

/**
 * @author macpro
 *
 */

@RestController
public class NotificacionController  {
	
	@Autowired
	INotifyService notificacionService;
	
	  
	
	@PostMapping("/susNot")
	public String subscribeUser(@RequestBody Token user) {
		return notificacionService.userTokenSubscribe(user.getUsuario(), user.getToken());
		
	}
	
	@PostMapping("/send")
	public String sendUser(@RequestBody String user) {
		return notificacionService.sendNotificacionLlamadaEntrante(user);
	}
	
	@PostMapping("/sendMessageSingUp")
	public String sendMessageSingUp(@RequestBody Usuario persona) throws Exception {
		return notificacionService.sendNotificacionSingUp(persona);
		
	}
	
	@PostMapping("/getCallPend")
	public LlamadaPendiente consultaLlamada(@RequestBody String user) {
		LlamadaPendiente llamada = null;
		try {
			llamada= notificacionService.buscaAtiendeLlamadaPendiente(user, null);
		} catch (Exception e) {
			
		}
		return llamada;
	}
	
	@PostMapping("/atiendeLlamado")
	public NotificacionVO atiendeLlamada(@RequestBody NotificacionVO notificacion) throws Exception{
		return notificacionService.atiendeLlamada(notificacion);
	}
	
	
	@PostMapping("/finalizaCall")
	public void finalizaLlamda(@RequestBody String idSol) throws Exception{
		notificacionService.finalizaLlamada(idSol);
	}
	
	@PostMapping("/notificacionjs")
	public NotificacionVO sendMessageSingUp() throws Exception {
		NotificacionVO not = new  NotificacionVO();
		not.setTopicDestino(notificacionService.getSktCnt());
		return not;
		
	}
	

}
