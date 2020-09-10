/**
 * 
 */
package com.medico.home.admon.cuestionario.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.cuestionario.model.ResCuest;

/**
 * @author macpro
 *
 */
public interface IResCuestDAO extends PagingAndSortingRepository<ResCuest, Long> {
	
	List<ResCuest> findByResIdAndCueId(Integer resId, Integer cueId);

}
