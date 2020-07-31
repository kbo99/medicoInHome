/**
 * 
 */
package com.medico.home.usuario.parametro.service;

import java.util.Map;

/**
 * @author macpro
 *
 */
public interface IParametroService {
	
	String findByPrmNombre(String prmNombre) throws Exception;
	
	 Map<String, String> findByPrmNombre(String... parmLst)throws Exception;

}
