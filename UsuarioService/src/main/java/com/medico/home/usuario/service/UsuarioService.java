/**
 * 
 */
package com.medico.home.usuario.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
			String passTmp = usuario.getUsuPassword();
			usuario.setUsuEstatus(Const.ESTATUS_ACTIVO);
			usuario.setUsuPassword(new BCryptPasswordEncoder().encode(usuario.getUsuPassword()));
			Grupo gpo = new Grupo();
			gpo.setGrpId(3);
			usuario.getGrupos().add(gpo);
			//se manda a guardar el usuario
			user = save(usuario);
		
			for( Grupo grupo : usuario.getGrupos()) {
				UsuGrupo usuGrp = new UsuGrupo();
				usuGrp.setId(new UsuGrupoEmbededId());
				usuGrp.getId().setUsuId(user.getUsuId());
				usuGrp.getId().setGrpId(grupo.getGrpId());
				usuGrupoDAO.save(usuGrp);
			}
			
			usuario.setUsuPassword(passTmp);
			} catch (Exception e) {
				logger.error("Error al generar nuevo usuario", e);
				throw new Exception(e);
			}
		
			
			try {
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
	
				String uri = parametroService.findByPrmNombre(Const.URL_SERVICE_SENDER_SING_UP);
				HttpEntity<String> entity = new HttpEntity<String>(new ObjectMapper().writeValueAsString(usuario), headers);
				restTemplate.exchange(uri, HttpMethod.POST, entity, Usuario.class);
			} catch (Exception e) {
				logger.error("::::::::::::: Error al generar Notificaciones SERVICE_SENDER :::::::::::::::::::", e);
			}
		
		return user;
	}

	@Override
	public List<Grupo> findGpoByUser(String user) throws Exception {
		String userCon = user.substring(1, 11);
		Usuario userTmp = usuGrupoDAO.getUsuUsuario(userCon); 
		return userTmp.getGrupos();
	}

	@Override
	public Usuario findByUsuUsuario(String usuUsuario) {
		Usuario usu = usuarioDAO.findByUsuUsuario(usuUsuario);
		return usu;
	}
	
	

}
