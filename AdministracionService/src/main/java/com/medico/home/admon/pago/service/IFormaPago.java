/**
 * 
 */
package com.medico.home.admon.pago.service;

import java.util.List;

import com.medico.home.commons.pago.model.FormaPago;

/**
 * @author rgarciaq
 *
 */
public interface IFormaPago {
	
	List<FormaPago> findByEstatus(String estatus) throws Exception;
	
	FormaPago save(FormaPago formaPago) throws Exception;

}
