/**
 * 
 */
package com.medico.home.admon.pago.service;

import java.util.List;

import com.medico.home.commons.pago.model.TipoPago;

/**
 * @author rgarciaq
 *
 */
public interface ITipoPago {
	
	TipoPago save(TipoPago tpoPago) throws Exception;
	
	
	List<TipoPago> findByEstatus(String estatus) throws Exception;

}
