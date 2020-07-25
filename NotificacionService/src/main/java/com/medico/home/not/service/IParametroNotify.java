/**
 * 
 */
package com.medico.home.not.service;

import java.util.Map;

/**
 * @author macpro
 *
 */
public interface IParametroNotify {
	
	String getParamValorById(String prnId);
	
	Map<String, String> getMapByParams(String... params);

}
