/**
 * 
 */
package com.medico.home.not.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.commons.doctor.model.Doctor;
import com.medico.home.commons.membresia.model.Membresia;
import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.IconAlert;
import com.medico.home.commons.util.Response;
import com.medico.home.not.model.LlamadaPendiente;
import com.medico.home.not.model.Token;
import com.medico.home.not.service.ILlamadaPendiente;
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
	public ResponseEntity<Response> subscribeUser(@RequestBody Token user) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(notificacionService.userTokenSubscribe(user.getUsuario(), user.getToken()));
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
	public ResponseEntity<Response> sendMessageSingUp(@RequestBody Usuario persona)  {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(notificacionService.sendNotificacionSingUp(persona));
			response.setMessage("");
			response.setTitle("");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar llamada");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	
		
	}
	
	@PostMapping("/getCallPend")
	public ResponseEntity<Response> consultaLlamada(@RequestBody String user) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(notificacionService.buscaAtiendeLlamadaPendiente(user, null));
			response.setMessage("");
			response.setTitle("");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar llamada");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
		
	}
	
	@PostMapping("/atiendeLlamado")
	public ResponseEntity<Response>  atiendeLlamada(@RequestBody NotificacionVO notificacion) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(notificacionService.atiendeLlamada(notificacion));
			response.setMessage("");
			response.setTitle("");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar llamada");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);

	}
	
	

	
	@PostMapping("/finalizaCall")
	public ResponseEntity<Response> finalizaLlamda(@RequestBody String idSol)  {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			
			response.setResponse(notificacionService.finalizaLlamada(idSol));
			response.setMessage("Llamada Finalizada");
			response.setTitle("Fin LLamada");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar llamada");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/notificacionjs")
	public ResponseEntity<Response> sendMessageSingUp() {
		
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			NotificacionVO not = new  NotificacionVO();
			not.setTopicDestino(notificacionService.getSktCnt());
			response.setResponse(not);
			response.setMessage("");
			response.setTitle("");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar llamada");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
		
		
	}
	
	
	@GetMapping("/listarllamada")
	public List<LlamadaPendiente>findallLlamadaPendiente(){
		return notificacionService.findallPendiente();
		
	}
	

}
