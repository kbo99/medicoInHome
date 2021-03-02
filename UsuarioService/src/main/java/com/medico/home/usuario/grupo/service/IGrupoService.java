package com.medico.home.usuario.grupo.service;

import java.util.List;

import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.UsuGrupo;
import com.medico.home.commons.usuario.model.Usuario;

/**
 * 
 * @author kbo99
 *
 */
public interface IGrupoService {

	void saveOrUpdateGrupo (Grupo grupo) throws Exception;
	
	void saveOrUpdateRoles(Usuario usup) throws Exception;
	
	List<Usuario> findUsuarioByUsuario(String usuUsuario);
	
	List<Usuario> findUsuarioByPerNombre(String perNombre);
	
	List<Grupo> findAllGrupos();
	
	
}
