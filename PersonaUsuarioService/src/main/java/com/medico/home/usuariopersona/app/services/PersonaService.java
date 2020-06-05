/**
 * 
 */
package com.medico.home.usuariopersona.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.usuariopersona.services.feign.IPersonaServiceFeign;

/**
 * @author kbo99
 *
 */
@Service
public class PersonaService  implements IPersonaService {

	@Autowired
	private IPersonaServiceFeign personaService;
	
	@Override
	public List<Persona> findAllPersonas() {
		return personaService.findAllPersonas();
	}
	@Override
	public Persona findPersonaByIs(Integer id) {
		return personaService.findPersonaByIs(id);
	}

}
