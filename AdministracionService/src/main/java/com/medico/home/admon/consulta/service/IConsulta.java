/**
 * 
 */
package com.medico.home.admon.consulta.service;

import java.util.List;

import com.medico.home.commons.consulta.model.Consulta;

/**
 * @author macpro
 *
 */
public interface IConsulta {

	
	Consulta save(Consulta consulta) throws Exception;
	
	List<Consulta> findByUserRegistra(String user) throws Exception;
	
	List<Consulta> findByTelefonoPac(String telefono) throws Exception;
}
