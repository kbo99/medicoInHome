/**
 * 
 */
package com.medico.home.persona.service;

import java.util.List;

import com.medico.home.commons.persona.model.Persona;


/**
 * @author kbo99
 *
 */
public interface IPersonaService {

	public List<Persona> findAllPersonas();
	public Persona findPersonaByIs (Integer id);
	
}
