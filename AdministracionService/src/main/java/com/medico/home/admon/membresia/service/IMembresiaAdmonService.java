/**
 * 
 */
package com.medico.home.admon.membresia.service;

import java.util.List;

import com.medico.home.commons.beneficio.model.Beneficio;

/**
 * @author macpro
 *
 */
public interface IMembresiaAdmonService {
	
	Beneficio save(Beneficio beneficio) throws Exception;
	
	Beneficio nuevoBeneficio(Beneficio beneficio) throws Exception;
	
	List<Beneficio> findBeneficioByBenEstatus(String benEstatus) throws Exception;
	

}
