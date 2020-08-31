/**
 * 
 */
package com.medico.home.admon.parametro.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.model.Parametro;

/**
 * @author macpro
 *
 */
public interface IParametroDAO extends PagingAndSortingRepository<Parametro, Integer> {
	
	Parametro findByPrmNombre(String prmNombre);
	
	List<Parametro> findByPrmNombreIn(List<String> lstParam);

}
