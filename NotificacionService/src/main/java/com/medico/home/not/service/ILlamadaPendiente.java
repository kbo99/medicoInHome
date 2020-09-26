/**
 * 
 */
package com.medico.home.not.service;

import java.util.List;

import com.medico.home.not.model.LlamadaPendiente;

/**
 * @author macpro
 *
 */
public interface ILlamadaPendiente {
	
	LlamadaPendiente save(LlamadaPendiente llamada) throws Exception;
	
	LlamadaPendiente buildLlamadaPenIni(String usuSol) throws Exception;
	
	LlamadaPendiente findByUsuSolAndLlpEstatus(String usuSol, String estatus)throws Exception;
	
	List<LlamadaPendiente> getFirstLlamadaPendienteByEstatus(String estatis)throws Exception;
	
	LlamadaPendiente asignaLlamadaMedicoGral()throws Exception;
	
	List<LlamadaPendiente> getLlamdaMedico(String userNameMedico)throws Exception;
	
	List<LlamadaPendiente> getLlamdaPaciente(String userName, String estatus)throws Exception;

}
