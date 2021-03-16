/**
 * 
 */
package com.medico.home.not.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medico.home.commons.util.Const;
import com.medico.home.not.model.LlamadaPendiente;
import com.medico.home.not.model.MedicoLlamada;
import com.medico.home.not.model.MedicoNotificacion;
import com.medico.home.not.model.NotificacionFcm;
import com.medico.home.not.service.ILlamadaPendiente;
import com.medico.home.not.service.INotificacionFCM;
import com.medico.home.not.service.INotifyService;
import com.medico.home.not.service.IParametroNotify;

/**
 * @author macpro
 *
 */
@RestController
@RequestMapping("/fcm")
public class NotficacionMovilController {
	
	@Autowired
	INotificacionFCM notificacionFcm;
	
	@Autowired
	INotifyService notifyService;
	
	@Autowired
	IParametroNotify parametroNotify;
	
	@Autowired
	ILlamadaPendiente llamadaPendienteService;
	
	Logger logger = LoggerFactory.getLogger(NotficacionMovilController.class);
	
	@PostMapping("/saveTkn")
	public NotificacionFcm subscribeUser(@RequestBody NotificacionFcm user) {
		return notificacionFcm.actualizaToken(user);
	}
	
	
	/**
	 * Metodo que genera la llamada pendiente y manda notificacion a operador 
	 * @param user
	 * @return
	 */
	@PostMapping("/generaNotifica")
	public List<NotificacionFcm>  generaNotifica(@RequestBody NotificacionFcm user) {
		List<NotificacionFcm> lstNoti = new ArrayList<NotificacionFcm>();
		//Se genera la llamada pendiente
		LlamadaPendiente result = notifyService.sendNotificacionLlamadaEntrante(user.getUsuUsuario());
		
		if(result != null) {
			user.setCanal(result.getUsuSol());
			user.setTknAgora(parametroNotify.getMapByParams(Const.TKN_LLAMADA_ANGORA).
					get(Const.TKN_LLAMADA_ANGORA));
			user.setIdLlamada(result.getLlpId().intValue());
			lstNoti = notificacionFcm.findTknDoctorUrgencia(user, Const.ATIENDE_OPERADOR, 
					Const.STRING_F);

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//String url = "https://www.doctoresensucasa.com/SenderNotWeb-0.0.1-SNAPSHOT/channelVideoCall";
			String url = "http://localhost:8089/channelVideoCall";
			try {
				HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(lstNoti), headers);
				restTemplate.exchange(url, HttpMethod.POST, entity, NotificacionFcm.class);
				
			} catch (Exception e) {
				lstNoti = null;
				logger.error("Error al generar llamada " + e.getMessage(), e);
				
			}
		}
		
		return lstNoti;
	}
	
	
	@PostMapping("/generaNotificaDoc")
	public List<NotificacionFcm>  generaNotificaMedico(@RequestBody NotificacionFcm user) {
		List<NotificacionFcm> lstNoti = new ArrayList<NotificacionFcm>();
		//Se genera la llamada pendiente
		LlamadaPendiente result = notifyService.sendNotificacionLlamadaEntrante(user.getUsuUsuario());
		
		if(result != null) {
			user.setCanal(result.getUsuSol());
			user.setTknAgora(parametroNotify.getMapByParams(Const.TKN_LLAMADA_ANGORA).
					get(Const.TKN_LLAMADA_ANGORA));
			lstNoti = notificacionFcm.findTknDoctorUrgencia(user, Const.ATIENDE_OPERADOR, 
					Const.STRING_F);

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String url = "https://www.doctoresensucasa.com/SenderNotWeb-0.0.1-SNAPSHOT/channelVideoCall";
			//String url = "http://localhost:8089/channelVideoCall";
			try {
				HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(lstNoti), headers);
				restTemplate.exchange(url, HttpMethod.POST, entity, NotificacionFcm.class);
				
			} catch (Exception e) {
				lstNoti = null;
				logger.error("Error al generar llamada " + e.getMessage(), e);
				
			}
		}
		
		return lstNoti;
	}
	
	@PostMapping("/atiendeOperador")
	public LlamadaPendiente atiendeOperador(@RequestBody NotificacionFcm notifica) throws Exception {
		return notifyService.atiendeOperador(notifica);
		
	}
	
	
	@PostMapping("/notificaMedico")
	public MedicoLlamada generaNotificaDoctor(@RequestBody MedicoLlamada medicoLlamda) throws Exception {
		LlamadaPendiente result = llamadaPendienteService.findById(medicoLlamda.getLlpId());
		if(result != null) {
			 NotificacionFcm user = new NotificacionFcm();
			 user.setCanal(result.getUsuSol());
			 user.setUsuUsuario(medicoLlamda.getUserMedico());
				user.setTknAgora(parametroNotify.getMapByParams(Const.TKN_LLAMADA_ANGORA).
						get(Const.TKN_LLAMADA_ANGORA));
				user.setTitulo("Video llamada");
				user.setMensaje("Paciente Espera en Video LLamada");
				user = notificacionFcm.generaNotificaLlamada(user);
				List<NotificacionFcm> lstNoti = new ArrayList<NotificacionFcm>();
				lstNoti.add(user);
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				medicoLlamda = notificacionFcm.guardaDetalleLlamada(medicoLlamda);
				String url = "https://www.doctoresensucasa.com/SenderNotWeb-0.0.1-SNAPSHOT/channelVideoCall";
				//String url = "http://localhost:8089/channelVideoCall";
				try {
					HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(lstNoti), headers);
					restTemplate.exchange(url, HttpMethod.POST, entity, NotificacionFcm.class);
					
				} catch (Exception e) {
					lstNoti = null;
					logger.error("Error al generar llamada " + e.getMessage(), e);
					
				}
				
		}
		return medicoLlamda;
	}
	
	
	@PostMapping("/atiendeDoctor")
	public MedicoLlamada atiendeDoctor(@RequestBody NotificacionFcm notifica) throws Exception {
		return notifyService.atiendeDoctor(notifica);
		
	}
	
	
}
