/**
 * 
 */
package com.medico.home.sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.sender.vo.NotificacionVO;

/**
 * @author macpro
 *
 */
@RestController
public class SendNotificaWebController {
	

	@Autowired
	private SimpMessagingTemplate websocket;
	
	@PostMapping("/mandaDoctor")
	public NotificacionVO mandaNtofiLlamadaDoc(@RequestBody NotificacionVO notifica) {
		this.websocket.convertAndSend(notifica.getTopicDestino(), notifica);
	    return notifica;
	   
	}
	
	@GetMapping("/mandaPaciente")
	public Object simpleTest(@DestinationVariable String fleetId) {
		this.websocket.convertAndSend("/topic/notify/call/test", "");
	    return new Object();
	}

}
