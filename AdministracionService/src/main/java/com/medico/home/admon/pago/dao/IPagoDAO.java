/**
 * 
 */
package com.medico.home.admon.pago.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.pago.model.Pago;

/**
 * @author rgarciaq
 *
 */

public interface IPagoDAO extends PagingAndSortingRepository<Pago, Long> {
	
	
	Pago save(Pago pago);
	
	List<Pago> findByPagoEstatusPgsId(Integer pgsId);

}
