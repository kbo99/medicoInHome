/**
 * 
 */
package com.medico.home.admon.pago.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.pago.model.PagoEstatus;

/**
 * @author rgarciaq
 *
 */
public interface IPagoEstatusDAO extends PagingAndSortingRepository<PagoEstatus, Long> {
	
	PagoEstatus save(PagoEstatus paoEstatus);
	
	List<PagoEstatus> findByPgsEstatus(String estatus);
}
