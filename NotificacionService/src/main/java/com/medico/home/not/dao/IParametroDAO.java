/**
 * 
 */
package com.medico.home.not.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.not.model.Parametro;

/**
 * @author macpro
 *
 */
public interface IParametroDAO extends PagingAndSortingRepository<Parametro, String> {
	
	List<Parametro> findByPrnIdIn(List<String> lstPrnId);

}
