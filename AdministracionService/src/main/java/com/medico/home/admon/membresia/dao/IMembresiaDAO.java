/**
 * 
 */
package com.medico.home.admon.membresia.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.membresia.model.Membresia;

/**
 * @author rgarciaq
 *
 */
@RepositoryRestResource(path = "membresia")
public interface IMembresiaDAO extends PagingAndSortingRepository<Membresia, Long> {
	
	List<Membresia> findByMemId(Integer memId);
	
	List<Membresia> findByMemEstatusAndMemNombre(String memEstatus, String memNommbre);
	
	List<Membresia> findByMemEstatus(String memEstatus);
	
	

}
