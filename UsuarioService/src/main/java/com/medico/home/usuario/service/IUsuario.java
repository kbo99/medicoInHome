/**
 * 
 */
package com.medico.home.usuario.service;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Usuario;

/**
 * @author macpro
 *
 */
public interface IUsuario {

	Usuario save(Usuario usuario) throws Exception;
	
	Usuario generateNuevo(Usuario usuario) throws Exception;
}
