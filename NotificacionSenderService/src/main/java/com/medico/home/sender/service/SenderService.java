/**
 * 
 */
package com.medico.home.sender.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.medico.home.sender.vo.NotificacionVO;
import com.twilio.Twilio;

/**
 * @author macpro
 *
 */
@Service
public class SenderService implements ISenderService {
	
	Logger logger = LoggerFactory.getLogger(SenderService.class);

	@Override
	public void sendMessageContingengia(NotificacionVO notificacion) {
		try {
			Twilio.init(notificacion.getMapConfig().get(TIWILIO_USER_MESSAGE), 
					notificacion.getMapConfig().get(TIWILIO_TKN_MESSAGE));
			
		       com.twilio.rest.api.v2010.account.Message messageWhat = com.twilio.rest.api.v2010.account.Message.creator(
		               new com.twilio.type.PhoneNumber("+521"+notificacion.getMapConfig().get(USER_NM_MESSAGE)),
		               new com.twilio.type.PhoneNumber(notificacion.getMapConfig().get(TIWILIO_NM_MESSAGE)),
		               notificacion.getMensaje())
		           .create();
		       messageWhat.getSid();
		} catch (Exception e) {
			logger.error("Error al mandar mensaje de text", e);
		}
	}

	@Override
	public void sendMessageContingengia() {
		try {
			Twilio.init("AC0d506b518801d1adea3d4862b63b7a9a", 
					"e604fb9928bb35647c39c215d348f46b");
			
		       com.twilio.rest.api.v2010.account.Message messageWhat = com.twilio.rest.api.v2010.account.Message.creator(
		               new com.twilio.type.PhoneNumber("+5215574689312"),
		               new com.twilio.type.PhoneNumber("+15103423126"),
		               "Prueba desde server")
		           .create();
		       messageWhat.getSid();
		} catch (Exception e) {
			logger.error("Error al mandar mensaje de text", e);
		}
		
	}

}
