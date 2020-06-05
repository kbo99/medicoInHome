/**
 * 
 */
package com.medico.home.oauth.service.persona;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medico.home.commons.persona.model.Persona;

/**
 * @author kbo99
 *
 */
@FeignClient(name = "servicio-personas")
public interface IPersonaServiceFeign {

	@GetMapping("/listar")
	public List<Persona> findAllPersonas();
	
	@GetMapping("/ver/{id}")
	public Persona findPersonaByIs (@PathVariable Integer id);
	
}
