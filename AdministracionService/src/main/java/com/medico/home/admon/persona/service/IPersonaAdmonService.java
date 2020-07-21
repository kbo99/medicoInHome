package com.medico.home.admon.persona.service;

import com.medico.home.commons.persona.model.Persona;

public interface IPersonaAdmonService {
	
	Persona save(Persona persona) throws Exception;
	
	Persona registraNueva(Persona persona) throws Exception;
	

}
