/**
 * 
 */
package com.medico.home.persona.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.medico.home.commons.persona.model.Persona;




/**
 * @author kbo99
 *
 */
public interface IPersonaDao  extends CrudRepository<Persona, Integer> {

	@Query("select p from  Persona p where perPombre =?1")
	public Persona findByPerNombreAndPerApeMaterno(String perNombre); 
	
}
