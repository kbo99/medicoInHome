/**
 * 
 */
package com.medico.home.admon.cliente.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.cliente.model.ClientePersona;

/**
 * @author macpro
 *
 */
public interface IClientePersonaDAO extends PagingAndSortingRepository<ClientePersona, Long> {

	ClientePersona findByPersonaPerTelefonoAndPerfilPersonaClientePpcId(String telefono, Integer pprId);
	
	List<ClientePersona> findByClienteCliIdAndPerfilPersonaClientePpcId(Integer cliId, Integer pprId);   
	
	List<ClientePersona> findByPerfilPersonaClientePpcId(Integer pprId); 
	
	ClientePersona findByCpeId(Integer cpeId);
	
	ClientePersona findByPersonaPerTelefono(String telefono);
}
    