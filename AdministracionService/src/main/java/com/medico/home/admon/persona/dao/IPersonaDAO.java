/**
 * 
 */
package com.medico.home.admon.persona.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.persona.model.Persona;

/**
 * @author macpro
 *
 */
@RepositoryRestResource(path = "rep-persona")
public interface IPersonaDAO extends PagingAndSortingRepository<Persona, Integer> {

}
