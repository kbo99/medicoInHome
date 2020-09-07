/**
 * 
 */
package com.medico.home.not.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.commons.membresia.model.Membresia;
import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.IconAlert;
import com.medico.home.commons.util.Response;
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
	public ResponseEntity<Response> sendUser(@RequestBody String user) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(notificacionService.sendNotificacionLlamadaEntrante(user));
			response.setMessage("");
			response.setTitle("");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar Perona");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
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
