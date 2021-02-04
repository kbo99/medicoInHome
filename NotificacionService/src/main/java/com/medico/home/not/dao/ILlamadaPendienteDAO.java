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
	
	List<LlamadaPendiente> findByUsuSolAndLlpEstatusOrderByLlpIdDesc(String usuSol, String estatus);
	
	List<LlamadaPendiente> findByLlpEstatusOrderByLlpFechaAsc(String estatus);
	
	List<LlamadaPendiente> findByUsuAtiendeOrderByLlpFechaDesc(String usuAtiende);
	
	List<LlamadaPendiente> findByUsuSolAndLlpEstatusOrderByLlpFechaDesc(String usuAtiende, String estatus);

}
