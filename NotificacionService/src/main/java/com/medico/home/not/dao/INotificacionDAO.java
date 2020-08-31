/**
 * 
 */
package com.medico.home.not.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.not.model.Notificacion;

/**
 * @author macpro
 *
 */
@RepositoryRestResource(path = "notidao")
public interface INotificacionDAO extends PagingAndSortingRepository<Notificacion, Long> {
	
	

}
