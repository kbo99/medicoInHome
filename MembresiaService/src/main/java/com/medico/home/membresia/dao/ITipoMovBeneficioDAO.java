/**
 * 
 */
package com.medico.home.membresia.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.beneficio.model.TipoMovimientoBene;

/**
 * @author rgarciaq
 *
 */
@RepositoryRestResource(path = "membresia")
public interface ITipoMovBeneficioDAO extends PagingAndSortingRepository<TipoMovimientoBene, Long> {
	
	TipoMovimientoBene findByTmbId(Integer tmbId);
	
	TipoMovimientoBene findByTmbNombre(String tmbNombre);
	
	List<TipoMovimientoBene> findAll();

}
