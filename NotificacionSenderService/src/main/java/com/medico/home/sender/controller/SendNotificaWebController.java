/**
 * 
 */
package com.medico.home.sender.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author macpro
 *
 */
@RestController
public class SendNotificaWebController {
	

	
	
	@MessageMapping("/notify/{fleetId}")
	@SendTo("/topic/notify/answer/{fleetId}")
	public Object simple(@DestinationVariable String fleetId) {
	    return new Object();
	}

}
