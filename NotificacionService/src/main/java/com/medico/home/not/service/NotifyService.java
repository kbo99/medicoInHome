/**
 * 
 */
package com.medico.home.not.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.Const;
import com.medico.home.not.dao.IMedicoNotifiacionDAO;
import com.medico.home.not.dao.ITokenDAO;
import com.medico.home.not.model.MedicoNotificacion;
import com.medico.home.not.model.Token;
import com.twilio.Twilio;


/**
 * @author macpro
 *
 */
@Service
public class NotifyService implements INotifyService {
	
	Logger logger = LoggerFactory.getLogger(NotifyService.class);
	
	@Autowired
	ITokenDAO tokenDAO;
	
	@Autowired
	IMedicoNotifiacionDAO medicoNotificacionDAO;
	
	@Autowired
	IParametroNotify parametroNotify;
	

	
	@Override
	public String userTokenSubscribe(String usuario, String token) {
		tokenDAO.save(new Token(usuario, token)); 
		return "guardado";
	}


	@Override
	public String sendNotificacionLlamadaEntrante(String userFrom) {
		//SE OBTIENEN LOS PARametors necesarios para mandar la notificacion de llamada a medoco
		Map<String, String> mapConfig = parametroNotify.getMapByParams(Const.TIWILIO_TKN_MESSAGE,
				Const.TIWILIO_USER_MESSAGE,Const.TIWILIO_NM_MESSAGE, Const.URL_SKT_MESSAGE, Const.TOPIC_LLAMADA_DOC);
		try {
			envioNotificacionLlamadaDoctor(mapConfig, userFrom);
		} catch (Exception e) {
			logger.error("Error al generar notify ", e);
		}
		
		return "succees o tal vez no";
	}
	
	private void envioNotificacionLlamadaDoctor(Map<String, String> mapConfig, String userFrom) {
		//Obtiene a los medicos disponibles
		medicoNotificacionDAO.findByMnrDispon(Const.STRING_V).forEach(item ->{
			//Se obtiene token para notificacion push
			Token tkn = tokenDAO.findByUsuario(item.getMnrUsu());
			//Si tiene token registrado se manda la notificacion push
			if(tkn != null)
				sendNotificationPush(new WebpushNotification("Tiene una llamada",
					"www.doctoresensucasa.com", "Doctores en su casa"), tkn.getToken());
			//Se manda el mensaje al doctor
			sendMessage(mapConfig, item.getMnrUsu(), "Un paciente solicita una videollamada \n "
					+ "Entre a:\n wwww.doctoresensucasa/admin/medicall");
			//se manda la notificacion al sockete
			sendNotificationToSocket(userFrom,mapConfig.get(Const.URL_SKT_MESSAGE),
					"Un paciente solicita una videollamada",mapConfig.get(Const.TOPIC_LLAMADA_DOC)+item.getMnrUsu(),
					"/medicall");
			
		});
	}
	
	
	
	private void sendNotificationToSocket(String userFrom, 
			String hostSender, String message, String topic, String accion) {
		
	     //Se construye el objeto de notificacion
			NotificacionVO noti = new NotificacionVO();
			noti.setIdLlamada(userFrom);
			noti.setMensaje(message);
			noti.setTopicDestino(topic);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			try {
				HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(noti), headers);
				restTemplate.postForLocation(hostSender, entity);
			} catch (Exception e) {
				logger.error("Error al generar notify ", e);
			}
			
	
	}
	
	
	private String sendMessage(Map<String, String> mapConfig,String userTo, String message) {
		String messa = "";
		if(mapConfig != null && 
				mapConfig.containsKey(Const.TIWILIO_USER_MESSAGE) && 
				mapConfig.containsKey(Const.TIWILIO_NM_MESSAGE) && 
				mapConfig.containsKey(Const.TIWILIO_TKN_MESSAGE)) {
			
			Twilio.init(mapConfig.get(Const.TIWILIO_USER_MESSAGE), mapConfig.get(Const.TIWILIO_TKN_MESSAGE));
			
		       com.twilio.rest.api.v2010.account.Message messageWhat = com.twilio.rest.api.v2010.account.Message.creator(
		               new com.twilio.type.PhoneNumber("+521"+userTo),
		               new com.twilio.type.PhoneNumber(mapConfig.get(Const.TIWILIO_NM_MESSAGE)),
		               message)
		           .create();
		       messa = messageWhat.getSid();
		}
		
	       
		return messa;
	}
	
	
	
	private String sendNotificationPush(WebpushNotification notifica,String token) {
		String response = "";
		notifica.builder().putCustomData("click_action", "www.doctoresensucasa.com");
		try {
		 Message message = Message.builder()
			            .setWebpushConfig(WebpushConfig.builder().putData("click_action", "www.doctoresensucasa.com")
			                .setNotification(notifica)
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
	public String sendNotificacionSingUp(Usuario persona) throws Exception {
		String response = "";
		try {
			StringBuffer message = new StringBuffer();
			message.append("Hola, ").append(" \n").append("Bienvendo a Doctores en su casa. \n")
			.append("Su usuario es su numero telefonico registrado. \n")
			.append(". \n")
			.append("Ingresar a www.doctoresensucasa.com/admin/login");
			
			Map<String, String> mapConfig = parametroNotify.getMapByParams(Const.TIWILIO_TKN_MESSAGE,
					Const.TIWILIO_USER_MESSAGE,Const.TIWILIO_NM_MESSAGE);
			response = sendMessage(mapConfig, persona.getUsuUsuario(),message.toString());
			
			persona.getGrupos().forEach(item->{
				if(item.getGrpId() == Const.PERFIL_USU_DOCTOR) {
					MedicoNotificacion mediNot = new MedicoNotificacion();
					mediNot.setMnrUsu(persona.getUsuUsuario());
					mediNot.setMnrDispon(Const.STRING_V);
					medicoNotifyAdd(mediNot);
				}
			
			});
					
		} catch (Exception e) {
			throw new Exception(e);
		}
		return response;
	}


	@Override
	public String medicoNotifyAdd(MedicoNotificacion mediNot) {
		try {
			medicoNotificacionDAO.save(mediNot);
		} catch (Exception e) {
			
		}
		return "success";
	}
	
	

}
