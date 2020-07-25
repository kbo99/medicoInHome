/**
 * 
 */
package com.medico.home.not.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.not.model.MedicoNotificacion;

/**
 * @author macpro
 *
 */
public interface IMedicoNotifiacionDAO extends PagingAndSortingRepository<MedicoNotificacion, Integer> {
	
	
	List<MedicoNotificacion> findByMnrDispon(String dispon);

}
