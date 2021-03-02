package com.medico.home.oauth.service.usuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.medico.home.commons.usuario.model.Usuario;

@FeignClient(name = "servicio-usuarios")
public interface IUsuarioFeign {
	
	//@GetMapping("/usuarios/search/busca-usuario")
	@GetMapping("/usuario/findbyusuarioin")
	public Usuario findByUsuUsuario(@RequestParam(name = "usuUsuario") String usuUsuario);
	//public Usuario findByUsuUsuario(@RequestBody String usuUsuario);
}
