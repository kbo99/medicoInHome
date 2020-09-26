/**
 * 
 */
package com.medico.home.admon.cuestionario.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.cuestionario.model.Cuestionario;

/**
 * @author macpro
 *
 */
public interface ICuestionarioDAO extends PagingAndSortingRepository<Cuestionario, Long> {
	
	Cuestionario findByTipoCuestTpcIdAndClientePersonaCpeIdAndCueEstatus(Integer tpcId, Integer cpeId, String estatus);
	
	Cuestionario findByCueId(Integer cueId);
	
	List<Cuestionario> findByClientePersonaCpeIdOrderByCueIdDesc(Integer cpeId);

}
