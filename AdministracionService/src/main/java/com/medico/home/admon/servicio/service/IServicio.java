/**
 * 
 */
package com.medico.home.admon.servicio.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.medico.home.commons.servicio.model.TipoServicio;

/**
 * @author macpro
 *
 */
public interface IServicio {
	
	TipoServicio save(TipoServicio tpoService) throws Exception;
	
	List<TipoServicio> findByTpsEstatus(String estatus);
	
	TipoServicio update(TipoServicio tpoService) throws Exception;

}
