/**
 * 
 */
package com.medico.home.not.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.util.Value;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.persona.model.Persona;
import com.medico.home.not.dao.ITokenDAO;
import com.medico.home.not.model.Token;
import com.twilio.Twilio;


/**
 * @author macpro
 *
 */
@Service
public class NotifyService implements INotifyService {
	
	@Autowired
	ITokenDAO tokenDAO;
	

	
	@Value("${app.sid-what}")
	private String sidWhat;
	
	@Value("${app.tkn-what}")
	private String tknWhat;
	
	@Value("${app.rest-service-llamada-doc-skt}")
	private String serviceSendNotificaLlamdaDoc;

	@Value("${app.number-what-from}")
	private String numberWhatFrom;
	
	
	
	@Override
	public String userTokenSubscribe(String usuario, String token,String origen) {
		tokenDAO.save(new Token(usuario, token, origen));
		return "guardado";
	}


	@Override
	public String sendNotificacionLlamadaEntrante(NotificacionVO userFrom) {
		 // This registration token comes from the client FCM SDKs.
		List<Token> tok = tokenDAO.findByTknOrigen( "D");
		sendNotificationToSocket(tok);
		//sendNotificacion(tok);
		
		return null;
	}
	
	
	private void sendNotificationToSocket(List<Token> userTo) {
		
	     
//		List<NotificacionVO> lstNot = new ArrayList<NotificacionVO>();
//	    URI result = restTemplate.postForLocation(serviceSendNotificaLlamdaDoc, NotificacionVO.class, lstNot);
	
	}
	
	
	private String sendMessage(String userTo, String message) {
		Twilio.init("AC0d506b518801d1adea3d4862b63b7a9a", "84474ff04ec0f04168868bb5abeeb903");
	       com.twilio.rest.api.v2010.account.Message messageWhat = com.twilio.rest.api.v2010.account.Message.creator(
	               new com.twilio.type.PhoneNumber(userTo),
	               new com.twilio.type.PhoneNumber("+15103423126"),
	               message)
	           .create();
	       
		return messageWhat.getSid();
	}
	
	
	
	private String sendNotificationPush(WebpushNotification notifica,String token) {
		String response = "";
		WebpushNotification  build = new WebpushNotification("Tiene una llamada",
				"www.doctoresensucasa.com", "Doctores en su casa");
		build.builder().putCustomData("click_action", "http://localhost:4200/#/medicall");
		try {
		 Message message = Message.builder()
			            .setWebpushConfig(WebpushConfig.builder().putData("click_action", "http://localhost:4200")
			                .setNotification(build)
			                .build())
			            .setToken(token)
			            .build();
			
			 
		 response = FirebaseMessaging.getInstance().send(message);
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return response;
	}


	@Override
	@Transactional(readOnly = true)
	public String sendNotificacionSingUp(Persona persona) throws Exception {
		String response = "";
		try {
			StringBuffer message = new StringBuffer();
			message.append("Hola, ").append(persona.getPerNombre()).
			append(" \n").append("Bienvendo a Doctores en su casa. \n")
			.append("Su usuario es su numero telefonico registrado. \n")
			.append("Su password es: ").append(persona.getPassword())
			.append(". \n")
			.append("Ingresar a www.doctoresensucasa.com/login");
			
			StringBuffer messageNumber = new StringBuffer("+521");
			messageNumber.append(persona.getPerTelefono());
			response = sendMessage(messageNumber.toString(),message.toString());
					
		} catch (Exception e) {
			throw new Exception(e);
		}
		return response;
	}
	
	

}
