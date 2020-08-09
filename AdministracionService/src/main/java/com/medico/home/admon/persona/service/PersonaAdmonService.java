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
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medico.home.admon.parametro.service.IParametroAdmService;
import com.medico.home.admon.persona.dao.IDoctorDAO;
import com.medico.home.admon.persona.dao.IPersonaDAO;
import com.medico.home.admon.usuario.service.IUsuarioFeign;
import com.medico.home.commons.doctor.model.Doctor;
import com.medico.home.commons.notificacion.NotificacionVO;
import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.Const;
import com.medico.home.commons.util.MedicBusinessException;

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
	
	@Autowired
	IParametroAdmService parametroAdmService;
	
	@Autowired
	IUsuarioFeign usuarioService;

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
			Usuario usuario = null;

			// si devuelve error el servicio es que no se encontro el usuario 
			try {
				usuario = usuarioService.findByUsuUsuario(userNew.getUsuUsuario());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if (usuario != null) {
				throw new MedicBusinessException("0001", "El usuario " + userNew.getUsuUsuario() + " ya existe");
			}
			
			usuarioService.generaNuevoUsuario(userNew);
			
		} catch (MedicBusinessException e) {
			throw (e);
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
