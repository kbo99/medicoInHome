/**
 * 
 */
package com.medico.home.admon.pago.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.pago.model.TipoPago;

/**
 * @author rgarciaq
 *
 */

public interface ITipoPagoDAO extends PagingAndSortingRepository<TipoPago, Long> {
	
	
	TipoPago save(TipoPago tpoPago);
	
	List<TipoPago> findByTppEstatus(String estatus);
	
	

}
