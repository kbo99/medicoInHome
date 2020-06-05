package com.medico.home.persona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.persona.dao.IPersonaDao;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAllPersonas() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findPersonaByIs(Integer id) {
		return personaDao.findById(id).orElse(null);
	}

}
