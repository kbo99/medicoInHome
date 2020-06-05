package com.medico.home.oauth.service.usuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medico.home.commons.usuario.model.Usuario;

@FeignClient(name = "servicio-usuarios")
public interface IUsuarioFeign {
	
	@GetMapping("/usuarios/search/busca-usuario")
	public Usuario findByUsuUsuario(@RequestParam String usuUsuario);
}
