/**
 * 
 */
package com.medico.home.admon.cuestionario.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.cuestionario.model.TipoCuest;

/**
 * @author macpro
 *
 */
public interface ITipoCuesDAO extends PagingAndSortingRepository<TipoCuest, Long> {
	
	TipoCuest findByTpcId(Integer tpcId);

}
