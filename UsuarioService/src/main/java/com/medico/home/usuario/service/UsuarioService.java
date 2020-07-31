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
import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.UsuGrupo;
import com.medico.home.commons.usuario.model.UsuGrupoEmbededId;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.Const;
import com.medico.home.usuario.dao.IUsuGrupoDAO;
import com.medico.home.usuario.dao.IUsuarioDAO;
import com.medico.home.usuario.parametro.service.IParametroService;

/**
 * @author macpro
 *
 */
@Service
public class UsuarioService implements IUsuario {
	
	Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	IUsuarioDAO usuarioDAO;
	
	@Autowired
	IUsuGrupoDAO usuGrupoDAO;
	
	@Autowired
	IParametroService parametroService;

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
	public Usuario generateNuevo(Usuario usuario) throws Exception {
		Usuario user = new Usuario();
		try {
			usuario.setUsuEstatus(Const.ESTATUS_ACTIVO);
			usuario.setUsuPassword(new BCryptPasswordEncoder().encode(usuario.getUsuPassword()));
			
			//se manda a guardar el usuario
			user = save(usuario);
		
			for( Grupo grupo : usuario.getGrupos()) {
				UsuGrupo usuGrp = new UsuGrupo();
				usuGrp.setId(new UsuGrupoEmbededId());
				usuGrp.getId().setUsuId(user.getUsuId());
				usuGrp.getId().setGrpId(grupo.getGrpId());
				usuGrupoDAO.save(usuGrp);
			}
			
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			String uri = parametroService.findByPrmNombre(Const.URL_SERVICE_SENDER_SING_UP);
			HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(usuario), headers);
			restTemplate.postForLocation(uri, entity);
			
			
		} catch (Exception e) {
			logger.error("Error al generar nuevo usuario", e);
			throw new Exception(e);
		}
		return user;
	}
	


}
