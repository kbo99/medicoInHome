/**
 * 
 */
package com.medico.home.not.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.not.model.LlamadaPendiente;

/**
 * @author macpro
 *
 */
public interface ILlamadaPendienteDAO extends PagingAndSortingRepository<LlamadaPendiente, Long> {
	
	LlamadaPendiente findByUsuSolAndLlpEstatus(String usuSol, String estatus);
	
	List<LlamadaPendiente> findByLlpEstatusOrderByLlpFechaAsc(String estatus);

}
