/**
 * 
 */
package com.medico.home.admon.parametro.service;

import java.util.Map;

/**
 * @author macpro
 *
 */
public interface IParametroAdmService {
	
	String findByPrmNombre(String prmNombre) throws Exception;
	
	 Map<String, String> findByPrmNombre(String... parmLst)throws Exception;

}
