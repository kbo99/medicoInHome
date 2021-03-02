package com.medico.home.usuario.grupo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.UsuGrupo;
import com.medico.home.commons.usuario.model.UsuGrupoEmbededId;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.Utils;
import com.medico.home.usuario.admin.service.IAdmonServiceFeign;
import com.medico.home.usuario.dao.IGrupoDAO;
import com.medico.home.usuario.dao.IUsuGrupoDAO;
import com.medico.home.usuario.dao.IUsuarioDAO;

/**
 * 
 * @author kbo99
 *
 */
@Service
public class GrupoService implements IGrupoService{

	@Autowired
	IUsuGrupoDAO usuGrupoDao;
	
	@Autowired
	IGrupoDAO grupoDao;
	
	@Autowired
	IUsuarioDAO usuarioDao;
	
	@Autowired
	IAdmonServiceFeign admonService;
	
	 Logger logger = LoggerFactory.getLogger(GrupoService.class);
	
	@Override
	@Transactional
	public void saveOrUpdateGrupo(Grupo grupo) throws Exception {
		try {
//			if (Utils.getNullToZero(grupo.getGrpId()) == null)
//				grupo.setGrpId(null);
			
			grupoDao.save(grupo);
			
		} catch (Exception e) {
			logger.error("Error al guardar Grupo", e);
			throw new Exception(e);
		}
	}

	@Override
	@Transactional
	public void saveOrUpdateRoles(Usuario usu) throws Exception {
		try {
			for( Grupo grupo : usu.getGrupos()) {
				UsuGrupo usuGrp = new UsuGrupo();
				usuGrp.setId(new UsuGrupoEmbededId());
				usuGrp.getId().setUsuId(usu.getUsuId());
				usuGrp.getId().setGrpId(grupo.getGrpId());
				usuGrupoDao.save(usuGrp);
			}
			
		} catch (Exception e) {
			logger.error("Error al guardar Roles", e);
			throw new Exception(e);
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findUsuarioByUsuario(String usuUsuario) {
		List<Usuario> listUsu= usuarioDao.findByUsuUsuarioContains(usuUsuario);
		if (!listUsu.isEmpty())
				listUsu.forEach(usua -> usua.setUsuPassword(null));
		
		return listUsu;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findUsuarioByPerNombre(String perNombre) {
		List<Persona> listPersonas = admonService.findpersonaByNombre(perNombre);
		List<Usuario> listUsu = new ArrayList<Usuario>();
		
		if (!listPersonas.isEmpty()) 
			listPersonas.forEach(persona -> {
				Usuario usu = usuarioDao.findByPerId(persona.getPerId());
				usu.setUsuPassword(null);
				//usu.setPersona(persona);
				listUsu.add(usu);
			});
		
		return listUsu;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Grupo> findAllGrupos() {
		return grupoDao.findBygrpEstatus("A");
	}

}
