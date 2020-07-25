/**
 * 
 */
package com.medico.home.admon.persona.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medico.home.admon.persona.dao.IDoctorDAO;
import com.medico.home.admon.persona.dao.IPersonaDAO;
import com.medico.home.commons.doctor.model.Doctor;
import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.Const;

/**
 * @author macpro
 *
 */
@Service
public class PersonaAdmonService implements IPersonaAdmonService {
	
	@Autowired
	IPersonaDAO personaDAO;
	
	@Autowired
	IDoctorDAO doctorDAO;

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
	public Persona registraNueva(Persona persona, List<Grupo> lstGrp) throws Exception {
		try {
			String pass = persona.getPassword();
			persona.setPerFalta(new Date());
			//Se genera la nueva persona
			persona = save(persona);
			
			Usuario userNew = new Usuario();
			userNew.setUsuUsuario(persona.getPerTelefono());
			userNew.setPerId(persona.getPerId());
			userNew.setUsuPassword(pass);
			userNew.setGrupos(lstGrp);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			try {
				HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(userNew), headers);
				restTemplate.postForLocation("http://localhost:8090/api/usuarios/generaUsuario", entity);
			} catch (Exception e) {
				logger.error("Error al generar persona ", e);
			}
			
			
			
		} catch (Exception e) {
			logger.error("Error al generar persona ", e);
			throw new Exception(e);
		}
		return persona;
	}

	@Override
	public Doctor save(Doctor doctor) throws Exception {
		return doctorDAO.save(doctor);
	}

	
	@Override
	public Doctor registraNuevo(Doctor doctor) throws Exception {
		try {
			List<Grupo> lstGrp = new ArrayList<Grupo>();
			Grupo grp = new Grupo();
			grp.setGrpId(Const.PERFIL_USU_DOCTOR);
			lstGrp.add(grp);
			//Se manda a generar nueva persona y usuario
			doctor.setPersona(registraNueva(doctor.getPersona(), lstGrp));
			doctor = save(doctor);
		} catch (Exception e) {
			logger.error("Error al doctor persona ", e);
			throw new Exception(e);
		}
		return doctor;
	}



}
