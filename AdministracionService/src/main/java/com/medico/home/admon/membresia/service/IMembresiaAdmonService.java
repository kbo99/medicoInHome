/**
 * 
 */
package com.medico.home.admon.membresia.service;

import java.util.List;

import com.medico.home.commons.beneficio.model.Beneficio;
import com.medico.home.commons.membresia.model.Membresia;

/**
 * @author macpro
 *
 */
public interface IMembresiaAdmonService {
	
	Beneficio save(Beneficio beneficio) throws Exception;
	
	Beneficio nuevoBeneficio(Beneficio beneficio) throws Exception;
	
	List<Beneficio> findBeneficioByBenEstatus(String benEstatus) throws Exception;
	
	List<Beneficio> getBeneficioAdmonMembresia(List<Integer> lstBenId, String estatus)throws Exception;
	
	Membresia save(Membresia membresia)throws Exception;
	
	Membresia nueva(Membresia membresia)throws Exception;
	

}
