/**
 * 
 */
package com.medico.home.not.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.Const;
import com.medico.home.not.dao.IMedicoNotifiacionDAO;
import com.medico.home.not.dao.ITokenDAO;
import com.medico.home.not.model.LlamadaPendiente;
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
	
	@Autowired
	ILlamadaPendiente llamadaPendienteService;
	
	
	
	@Override
	public String userTokenSubscribe(String usuario, String token) {
		tokenDAO.save(new Token(usuario, token)); 
		return "guardado";
	}


	@Override
	public String sendNotificacionLlamadaEntrante(String userFrom) {
	
		try {
			//SE OBTIENEN LOS PARametors necesarios para mandar la notificacion de llamada a medoco
		Map<String, String> mapConfig = parametroNotify.getMapByParams(Const.TIWILIO_TKN_MESSAGE,
				Const.TIWILIO_USER_MESSAGE,Const.TIWILIO_NM_MESSAGE, Const.URL_SKT_MESSAGE, Const.TOPIC_LLAMADA_DOC,
				Const.TKN_LLAMADA_ANGORA,Const.URL_SKT_MESSAGE_CLI);
		
		LlamadaPendiente llam = llamadaPendienteService.findByUsuSolAndLlpEstatus(userFrom, Const.ESTATUS_LLAMADA_X_ATENDER);
		if(llam != null) {
			//si existe una llamada se cancela(llamada Perdida) 
			llam.setLlpEstatus(Const.ESTATUS_LLAMADA_NO_ATENDIDA);
			llam.setLlpAtendida(Const.STRING_F);
			llam.setLlpFecha(new Date());
			llam.setUsuSol(userFrom);
			llamadaPendienteService.save(llam);
		}
		//Se genera la nueva llamada
		llamadaPendienteService.buildLlamadaPenIni(userFrom);
		
		envioNotificacionLlamadaDoctor(mapConfig, userFrom);
		} catch (Exception e) {
			logger.error("Error al generar notify ", e);
		}
		
		return "success";
	}
	
	private void envioNotificacionLlamadaDoctor(Map<String, String> mapConfig, String userFrom) {
		//Obtiene a los medicos disponibles
		medicoNotificacionDAO.findByMnrDispon(Const.STRING_V).forEach(item ->{
			//Se obtiene token para notificacion push
			Token tkn = tokenDAO.findByUsuario(item.getMnrUsu());
			//Si tiene token registrado se manda la notificacion push
			if(tkn != null)
				//sendNotificationPush(new WebpushNotification("Tiene una llamada",
				//	"www.doctoresensucasa.com", "Doctores en su casa"), tkn.getToken());
			//Se manda el mensaje al doctor
			//sendMessage(mapConfig, item.getMnrUsu(), "Un paciente solicita una videollamada \n "
				//	+ "Entre a:\n wwww.doctoresensucasa/admin/medicall");
			mapConfig.put(Const.USER_NM_MESSAGE, item.getMnrUsu());
			//se manda la notificacion al sockete
			sendNotificationToSocket(item.getMnrUsu(),mapConfig.get(Const.URL_SKT_MESSAGE),
					"Paciente solicita videollamada: "
					+ "https://doctoresensucasa.com/admin/#/login",mapConfig.get(Const.TOPIC_LLAMADA_DOC)+item.getMnrUsu(),
					"/medicall", mapConfig.get(Const.TKN_LLAMADA_ANGORA),userFrom, mapConfig);
			
		});
	}
	
	
	
	private void sendNotificationToSocket(String userFrom, 
			String hostSender, String message, String topic, String accion, 
			String angoraTKn, String userTo, Map<String, String> mapConfig) {
		
	     //Se construye el objeto de notificacion
			NotificacionVO noti = new NotificacionVO();
			noti.setIdLlamada(userFrom);
			noti.setMensaje(message);
			noti.setTopicDestino(topic);
			noti.setAngoraString(angoraTKn);
			noti.setSendFromUser(userFrom);
			noti.setSendToUser(userTo);
			noti.setMapConfig(mapConfig);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			try {
				HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(noti), headers);
				logger.info("///////////////////////"+hostSender);
				restTemplate.exchange(hostSender, HttpMethod.POST, entity, NotificacionVO.class);
				
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
	
	
	
	@SuppressWarnings("static-access")
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
		Message message2 = Message.builder().setAndroidConfig(AndroidConfig.builder().
				setNotification(AndroidNotification.builder().setTitle("Notificacion").build()).build()).build();
			 
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
			.append(" Su password es: ")
			.append(persona.getUsuPassword())
			.append(" Ingresar https://doctoresensucasa.com/admin/#/login");
			
			Map<String, String> mapConfig = parametroNotify.getMapByParams(Const.TIWILIO_TKN_MESSAGE,
					Const.TIWILIO_USER_MESSAGE,Const.TIWILIO_NM_MESSAGE,Const.URL_SKT_MESSAGE_SENDER);
			//response = sendMessage(mapConfig, persona.getUsuUsuario(),message.toString());
			
			mapConfig.put(Const.USER_NM_MESSAGE, persona.getUsuUsuario());
			sendNotificationToSocket(null,mapConfig.get(Const.URL_SKT_MESSAGE_SENDER),
					message.toString(),null,
					null, null,null, mapConfig);
			
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


	@Override
	public LlamadaPendiente buscaAtiendeLlamadaPendiente(String medicoId,Map<String, String> mapConfig) throws Exception {
		LlamadaPendiente llamda = null;
		try {
			if(mapConfig == null) {
				mapConfig = parametroNotify.getMapByParams(Const.TIWILIO_TKN_MESSAGE,
						Const.TIWILIO_USER_MESSAGE,Const.TIWILIO_NM_MESSAGE, Const.URL_SKT_MESSAGE, 
						Const.TOPIC_LLAMADA_PAC, Const.TKN_LLAMADA_ANGORA,Const.URL_SKT_MESSAGE_CLI);
			}
			List<LlamadaPendiente> lstLlamadaPendientes = 
					llamadaPendienteService.getFirstLlamadaPendienteByEstatus(Const.ESTATUS_LLAMADA_X_ATENDER);
			if(lstLlamadaPendientes != null && lstLlamadaPendientes.size() > 0) {
				 for(LlamadaPendiente llamada : lstLlamadaPendientes) {
					 llamada.setLlpAtendida(Const.STRING_V);
					 llamada.setLlpEstatus(Const.ESTATUS_LLAMADA_ATENDIDA);
					 llamada.setUsuAtiende(medicoId);
					 //se valida que la llamda no haya cambiado de estatus en el inter por si la tomo 
					 //otro medico si no es null quiere decir que no cambio estatus y se asigna
					if(llamadaPendienteService.findByUsuSolAndLlpEstatus(llamada.getUsuSol(), 
							Const.ESTATUS_LLAMADA_X_ATENDER) != null) {
						// asigna llamada
						llamda = llamadaPendienteService.save(llamada);
						llamda.setTknAgora(mapConfig.get(Const.TKN_LLAMADA_ANGORA));
						MedicoNotificacion mod = medicoNotificacionDAO.findByMnrUsu(medicoId);
						mod.setMnrDispon(Const.STRING_F);
						//se aparta el medico y se mandan notifc¡icaciones
						medicoNotifyAdd(mod);
						//falta envio de notificacion paciente
						//Se obtiene token para notificacion push
						Token tkn = tokenDAO.findByUsuario(llamada.getUsuSol());
						//Si tiene token registrado se manda la notificacion push
						if(tkn != null)
							sendMessagesPacienteLlamada(mapConfig, tkn.getToken(), llamada.getUsuSol(),medicoId);
						
					}else {
						//quiere decir que cambio de estatus vuelve a consultar las pendientes
						buscaAtiendeLlamadaPendiente(medicoId,mapConfig);
					}
				 }
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return llamda == null ? new LlamadaPendiente() : llamda;
	}


	
	@Override
	public NotificacionVO atiendeLlamada(NotificacionVO medico) throws Exception {
		try {
			Map<String, String> mapConfig = parametroNotify.getMapByParams(Const.TIWILIO_TKN_MESSAGE,
					Const.TIWILIO_USER_MESSAGE,Const.TIWILIO_NM_MESSAGE, Const.URL_SKT_MESSAGE, 
					Const.TOPIC_LLAMADA_PAC, Const.TKN_LLAMADA_ANGORA,Const.URL_SKT_MESSAGE_CLI);
			//Va por la llamada
			LlamadaPendiente llamamdaPendiente = llamadaPendienteService.findByUsuSolAndLlpEstatus(medico.getSendToUser(), 
					Const.ESTATUS_LLAMADA_X_ATENDER);
			//si no han tomado la llamada la tomamos
			if(llamamdaPendiente != null) {
				llamamdaPendiente.setLlpAtendida(Const.STRING_V);
				llamamdaPendiente.setLlpEstatus(Const.ESTATUS_LLAMADA_ATENDIDA);
				llamamdaPendiente.setUsuAtiende(medico.getSendFromUser());
				

				
				//Recuperamos el token
				Token tkn = tokenDAO.findByUsuario(medico.getSendToUser());
				
				MedicoNotificacion mod = medicoNotificacionDAO.findByMnrUsu(medico.getSendFromUser());
				mod.setMnrDispon(Const.STRING_F);
				//se aparta el medico y se mandan notifc¡icaciones
				medicoNotifyAdd(mod);

				//Se mandan los mensajes
				sendMessagesPacienteLlamada(mapConfig, tkn.getToken(), medico.getSendToUser(), medico.getSendFromUser());
			}
			
		} catch (Exception e) {
			logger.error("",e);
		}
		// TODO Auto-generated method stub
		return medico;
	}
	


	private void sendMessagesPacienteLlamada(Map<String, String> mapConfig, String tkn, String usuSol, 
			String usuFrom) {
		//sendNotificationPush(new WebpushNotification("Su llamada fue atendida",
		//		"www.doctoresensucasa.com", "Doctores en su casa"), tkn);
		//Se manda el mensaje al paciente
		//sendMessage(mapConfig, usuSol, "Su llamada fue atendida \n "
		//		+ "Entre a:\n wwww.doctoresensucasa/admin/medicall");
		mapConfig.put(Const.USER_NM_MESSAGE, usuSol);
		//se manda la notificacion al sockete
		sendNotificationToSocket(usuSol,mapConfig.get(Const.URL_SKT_MESSAGE_CLI),
				"Su llamada fue atendida",mapConfig.get(Const.TOPIC_LLAMADA_PAC)+usuSol,
				"/clicall", mapConfig.get(Const.TKN_LLAMADA_ANGORA),usuFrom, mapConfig);
	}


	@Override
	public LlamadaPendiente finalizaLlamada(String userSol) throws Exception {
		LlamadaPendiente llamamdaPendiente = new LlamadaPendiente();
		try {
			 llamamdaPendiente = llamadaPendienteService.findByUsuSolAndLlpEstatus(userSol, 
					Const.ESTATUS_LLAMADA_ATENDIDA);
			 if(llamamdaPendiente != null ) {
				 llamamdaPendiente.setLlpEstatus(Const.ESTATUS_LLAMADA_ATENDIDA_FIN);
					llamamdaPendiente.setLlpFechaFin(new Date());
					llamadaPendienteService.save(llamamdaPendiente);
					MedicoNotificacion mod = medicoNotificacionDAO.findByMnrUsu(llamamdaPendiente.getUsuAtiende());
					if(mod != null) {
						mod.setMnrDispon(Const.STRING_V);
						
						//se aparta el medico y se mandan notifc¡icaciones
						medicoNotifyAdd(mod);
					}
					
					
			 }
			
		} catch (Exception e) {
			logger.error("",e);
			throw new Exception();
		}
		return llamamdaPendiente;
	}


	@Override
	public String getSktCnt() throws Exception {
		String skt = null;
		try {
			skt = parametroNotify.getParamValorById(Const.URL_SKT_SUSCRIBE);
		} catch (Exception e) {
			logger.error("",e);
		}
		return skt;
	}

	


	

	
	

}
