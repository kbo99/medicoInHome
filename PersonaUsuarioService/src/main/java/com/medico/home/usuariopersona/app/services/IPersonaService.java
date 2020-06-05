package com.medico.home.usuariopersona.app.services;

import java.util.List;

import com.medico.home.commons.persona.model.Persona;


public interface IPersonaService {

	
	public List<Persona> findAllPersonas();
	public Persona findPersonaByIs (Integer id);
}
