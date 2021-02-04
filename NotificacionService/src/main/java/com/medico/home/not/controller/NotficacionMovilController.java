/**
 * 
 */
package com.medico.home.not.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.util.IconAlert;
import com.medico.home.commons.util.Response;
import com.medico.home.not.model.NotificacionFcm;
import com.medico.home.not.model.Token;
import com.medico.home.not.service.INotificacionFCM;

/**
 * @author macpro
 *
 */
@RestController
@RequestMapping("/fcm")
public class NotficacionMovilController {
	
	@Autowired
	INotificacionFCM notificacionFcm;

	@PostMapping("/saveTkn")
	public NotificacionFcm subscribeUser(@RequestBody NotificacionFcm user) {
		return notificacionFcm.actualizaToken(user);
	}
	
	
	@PostMapping("/generaNotifica")
	public List<NotificacionFcm>  generaNotifica(@RequestBody NotificacionFcm user) {
		List<NotificacionFcm> lstNoti = notificacionFcm.findTknDoctorUrgencia(user);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//String url = "https://www.doctoresensucasa.com/SenderNotWeb-0.0.1-SNAPSHOT/channelVideoCall";
		String url = "http://localhost:8089/channelVideoCall";
		try {
			HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(lstNoti), headers);
			restTemplate.exchange(url, HttpMethod.POST, entity, NotificacionFcm.class);
			
		} catch (Exception e) {
			
		}
		return lstNoti;
	}
}
