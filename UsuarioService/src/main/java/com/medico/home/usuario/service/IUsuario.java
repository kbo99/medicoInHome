/**
 * 
 */
package com.medico.home.usuario.service;

import java.util.List;

import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.Usuario;

/**
 * @author macpro
 *
 */
public interface IUsuario {

	Usuario save(Usuario usuario) throws Exception;
	
	Usuario generateNuevo(Usuario usuario) throws Exception;
	
	List<Grupo> findGpoByUser(String user) throws Exception;
}
