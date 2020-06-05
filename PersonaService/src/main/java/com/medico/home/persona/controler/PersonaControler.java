/**
 * 
 */
package com.medico.home.persona.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.persona.service.IPersonaService;


/**
 * @author kbo99
 *
 */
@RestController
public class PersonaControler {

	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/listar")
	public List<Persona> listar(){
		System.out.println(port);
		return personaService.findAllPersonas();
	}

	@GetMapping("/ver/{id}")
	public Persona detalle(@PathVariable Integer id) {
		return personaService.findPersonaByIs(id);
	}
}
