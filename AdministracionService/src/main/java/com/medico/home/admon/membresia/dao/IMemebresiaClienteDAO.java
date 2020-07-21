/**
 * 
 */
package com.medico.home.admon.membresia.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.membresia.model.MembresiaCliente;

/**
 * @author rgarciaq
 *
 */
@RepositoryRestResource(path = "membresia-cliente")
public interface IMemebresiaClienteDAO extends PagingAndSortingRepository<MembresiaCliente, Long> {

	List<MembresiaCliente> findByClientePersonaClienteCliId(Integer cliId);

	List<MembresiaCliente> findByClientePersonaClienteCliNomCorto(String nombre);

	List<MembresiaCliente> findByClientePersonaPersonaPerId(Integer perId);

	List<MembresiaCliente> findByClientePersonaClienteCliIdAndMecEstatus(Integer cliId, String mecEstatus);

	List<MembresiaCliente> findByClientePersonaClienteCliNomCortoAndMecEstatus(String nombre, String mecEstatus);

	List<MembresiaCliente> findByClientePersonaPersonaPerIdAndMecEstatus(Integer perId, String mecEstatus);
	
	List<MembresiaCliente> findByMecFinicioBetween(Date fechaIn, Date fechaFin);
	
	List<MembresiaCliente> findByMecFvencimientoBetween(Date fechaIn, Date fechaFin);
	
	List<MembresiaCliente> findByClientePersonaPersonaPerIdIn(List<Integer> perId);
	
	List<MembresiaCliente> findByClientePersonaClienteCliIdIn(List<Integer> cliId);
	
	List<MembresiaCliente> findByClientePersonaClienteCliNomCortoLikeAndMecEstatus(String nombre, String mecEstatus);
	
	List<MembresiaCliente> findByClientePersonaCpeId(Integer cpeId);
	
	List<MembresiaCliente> findByClientePersonaCpeIdAndMecEstatus(Integer cliId, String mecEstatus);
	
	List<MembresiaCliente> findByClientePersonaCpeIdInAndMecEstatus(List<Integer> cliId, String mecEstatus);
	
	

}
