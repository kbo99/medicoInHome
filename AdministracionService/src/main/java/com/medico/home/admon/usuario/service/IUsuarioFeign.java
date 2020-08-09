package com.medico.home.admon.usuario.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Usuario;

@FeignClient(name = "servicio-usuarios")
public interface IUsuarioFeign {
	
	@PostMapping("/generaUsuario")
	public Persona generaNuevoUsuario(@RequestBody  Usuario usuario); 
	
	@GetMapping("/usuarios/search/busca-usuario")
	public Usuario findByUsuUsuario(@RequestParam String usuUsuario);
}
