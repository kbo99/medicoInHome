/**
 * 
 */
package com.medico.home.admon.persona.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.persona.model.Persona;

/**
 * @author macpro
 *
 */
public interface IPersonaDAO extends PagingAndSortingRepository<Persona, Integer> {

}
