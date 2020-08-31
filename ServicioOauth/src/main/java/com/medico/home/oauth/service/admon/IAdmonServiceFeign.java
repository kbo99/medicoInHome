package com.medico.home.oauth.service.admon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medico.home.commons.persona.model.Persona;

@FeignClient(name="servicio-admin")
public interface IAdmonServiceFeign {

	@GetMapping("/rep-persona/{id}")
	public Persona findPersonaById (@PathVariable Integer id);
}
