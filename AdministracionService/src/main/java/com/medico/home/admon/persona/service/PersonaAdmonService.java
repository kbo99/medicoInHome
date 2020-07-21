/**
 * 
 */
package com.medico.home.admon.persona.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medico.home.admon.persona.dao.IPersonaDAO;

import com.medico.home.commons.persona.model.Persona;

/**
 * @author macpro
 *
 */
@Service
public class PersonaAdmonService implements IPersonaAdmonService {
	
	@Autowired
	IPersonaDAO personaDAO;

    Logger logger = LoggerFactory.getLogger(PersonaAdmonService.class);
    
    
	@Override
	public Persona save(Persona persona) throws Exception {
		try {
		
			persona = personaDAO.save(persona);
		} catch (Exception e) {
			logger.error("Error al guardar/actualizar persona ", e);
			throw new Exception(e);
		}
		// TODO Auto-generated method stub
		return persona;
	}

	/*
	 * Metodo encargado de generar una nueva persona
	 */
	@Override
	
	public Persona registraNueva(Persona persona) throws Exception {
		try {
			String pass = persona.getPassword();
			persona.setPerFalta(new Date());
			//Se genera la nueva persona
			persona = save(persona);
			
			//Se genera el nuevo usuario y se notifica
			persona.setPassword(pass);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(persona), headers);
			restTemplate.postForLocation("http://localhost:8090/api/usuarios/generaUsuario", entity);
			
			
		} catch (Exception e) {
			logger.error("Error al generar persona ", e);
			throw new Exception(e);
		}
		return persona;
	}



}
