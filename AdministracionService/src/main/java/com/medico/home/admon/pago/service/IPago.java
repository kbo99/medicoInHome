/**
 * 
 */
package com.medico.home.admon.pago.service;

import java.util.List;

import com.medico.home.commons.pago.model.Pago;

/**
 * @author rgarciaq
 *
 */
public interface IPago {
	
	Pago save(Pago pago) throws Exception;
	
	
	
	List<Pago> findByPagoEstatus(Integer pgsId) throws Exception;
	

}
