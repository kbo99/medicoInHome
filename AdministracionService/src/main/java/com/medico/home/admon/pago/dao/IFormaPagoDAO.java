/**
 * 
 */
package com.medico.home.admon.pago.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.pago.model.FormaPago;

/**
 * @author rgarciaq
 *
 */

public interface IFormaPagoDAO extends PagingAndSortingRepository<FormaPago, Long> {
	
	FormaPago save(FormaPago frmPago);
	
	List<FormaPago> findByFpaEstatus(String estatus);

}
