/**
 * 
 */
package com.medico.home.admon.persona.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Usuario;

/**
 * @author macpro
 *
 */
@RepositoryRestResource(path = "rep-persona")
public interface IPersonaDAO extends PagingAndSortingRepository<Persona, Integer> {

	
	@RestResource(path = "busca-nombre")
	public List<Persona> findByPerNombreIgnoreCaseContaining (@RequestParam String perNombre);
}
