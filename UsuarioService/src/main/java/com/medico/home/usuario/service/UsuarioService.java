/**
 * 
 */
package com.medico.home.usuario.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.Const;
import com.medico.home.usuario.dao.IUsuarioDAO;

/**
 * @author macpro
 *
 */
@Service
public class UsuarioService implements IUsuario {
	
	Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	IUsuarioDAO usuarioDAO;

	@Override
	public Usuario save(Usuario usuario) throws Exception {
		try {
			usuario = usuarioDAO.save(usuario);
		} catch (Exception e) {
			logger.error("Error al guardar nuevo usuario", e);
			throw new Exception(e);
		}
		return usuario;
	}

	@Override
	public Usuario generateNuevo(Persona usuario) throws Exception {
		Usuario user = new Usuario();
		try {
			user.setUsuEstatus(Const.ESTATUS_ACTIVO);
			user.setUsuPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
			user.setPerId(usuario.getPerId());
			user.setUsuUsuario(usuario.getPerTelefono());
			//se manda a guardar el usuario
			user = save(user);
		
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(usuario), headers);
			restTemplate.postForLocation("http://localhost:8090/api/notificacion/sendMessageSingUp", entity);
			
			
		} catch (Exception e) {
			logger.error("Error al generar nuevo usuario", e);
			throw new Exception(e);
		}
		return user;
	}
	


}
