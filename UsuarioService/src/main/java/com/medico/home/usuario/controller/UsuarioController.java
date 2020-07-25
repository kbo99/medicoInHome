/**
 * 
 */
package com.medico.home.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.usuario.service.IUsuario;

/**
 * @author macpro
 *
 */
@RestController
public class UsuarioController {
	
	
	
	@Autowired
	IUsuario usuarioService;
	
	
	
	@PostMapping("/generaUsuario")
	public Persona generaNuevoUsuario(@RequestBody  Usuario usuario) throws Exception {
		Usuario userTmp = null;
		try {
			usuarioService.generateNuevo(usuario); 
		} catch (Exception e) {
			throw new Exception();
		}
		return null;
	}

}
