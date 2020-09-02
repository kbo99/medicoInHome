/**
 * 
 */
package com.medico.home.admon.pago.service;

import java.util.List;

import com.medico.home.commons.pago.model.PagoEstatus;

/**
 * @author rgarciaq
 *
 */
public interface IPagoEstatus {
	
	List<PagoEstatus> findByEstatus(String estatus) throws Exception;
	
	PagoEstatus save(PagoEstatus PagoEstatus) throws Exception; 

}
