package com.medico.home.admon.persona.service;

import java.util.List;

import com.medico.home.commons.doctor.model.Doctor;
import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Grupo;

public interface IPersonaAdmonService {
	
	Persona save(Persona persona) throws Exception;
	
	Persona registraNueva(Persona persona, List<Grupo> lstGrp) throws Exception;
	
	List<Persona> findAllPersonas();
	
	Persona findPersonaById (Integer id);
	
	Doctor save(Doctor doctor) throws Exception;
	
	Doctor registraNuevo(Doctor doctor) throws Exception;
	
	List<Doctor> findallDoctor();

}
