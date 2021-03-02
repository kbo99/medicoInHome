package com.medico.home.usuario.admin.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medico.home.commons.persona.model.Persona;

@FeignClient(name="servicio-admin")
public interface IAdmonServiceFeign {

	@GetMapping("/rep-persona/{id}")
	public Persona findPersonaById (@PathVariable("id") Integer id);
	
	@GetMapping("/rep-persona/busca-nombre")
	public List<Persona> findpersonaByNombre (@PathVariable("perNombre") String perNombre);
}
