/**
 * 
 */
package com.medico.home.admon.membresia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.beneficio.model.Beneficio;
import com.medico.home.commons.membresia.model.MembresiaBeneficio;

/**
 * @author macpro
 *
 */
public interface IMembresiaBeneficioDAO extends PagingAndSortingRepository<MembresiaBeneficio, Integer> {

	@Query("SELECT ben.beneficio FROM MembresiaBeneficio ben where ben.membresia.memId = ?1")
	List<Beneficio> getBeneficiosBymm(Integer memid);
}
