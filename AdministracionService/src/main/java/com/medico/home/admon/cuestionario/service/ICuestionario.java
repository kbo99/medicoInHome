/**
 * 
 */
package com.medico.home.admon.cuestionario.service;

import java.util.List;

import com.medico.home.commons.cuestionario.model.Cuestionario;
import com.medico.home.commons.cuestionario.model.Seccion;

/**
 * @author macpro
 *
 */
public interface ICuestionario {
	
	List<Seccion> getListSeccByTpoCues(Integer tpoCues) throws Exception;
	
	Cuestionario getCuestionarioByCpeIdAndTpoCues(Integer cpeId, Integer tpoCu) throws Exception;
	
	List<Seccion> getListSeccByTpoCues(Integer tpoCues, Integer cueId) throws Exception;
	
	Cuestionario generaNuevo(Cuestionario cuestionario)throws Exception;
	
	Cuestionario save(Cuestionario cuestionario)throws Exception;
	

}
