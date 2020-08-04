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

import com.medico.home.sender.service.ISenderService;
import com.medico.home.sender.vo.NotificacionVO;

/**
 * @author macpro
 *
 */
@RestController
public class SendNotificaWebController {
	
	@Autowired
	ISenderService senderService;

	@Autowired
	private SimpMessagingTemplate websocket;
	
	@PostMapping("/mandaDoctor")
	public NotificacionVO mandaNtofiLlamadaDoc(@RequestBody NotificacionVO notifica) {
		senderService.sendMessageContingengia(notifica);
		this.websocket.convertAndSend(notifica.getTopicDestino(), notifica);
		this.websocket.convertAndSend("/topic/notify/incomincall/"+notifica.getSendFromUser(), notifica);
	    return notifica;
	   
	}
	
	@PostMapping("/mandaPaciente")
	public NotificacionVO simpleTest(@RequestBody NotificacionVO notifica) {
		senderService.sendMessageContingengia(notifica);
		this.websocket.convertAndSend("/topic/notify/call/"+notifica.getSendFromUser(), notifica);
	    return notifica;
	}
	
	@PostMapping("/mandaMensaje")
	public NotificacionVO sendMessa(@RequestBody NotificacionVO notifica) {
		senderService.sendMessageContingengia(notifica);
	    return new NotificacionVO();
	}

}
