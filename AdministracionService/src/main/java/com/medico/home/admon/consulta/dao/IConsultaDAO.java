/**
 * 
 */
package com.medico.home.admon.consulta.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.consulta.model.Consulta;

/**
 * @author macpro
 *
 */
public interface IConsultaDAO extends PagingAndSortingRepository<Consulta , Long> {
	
	
	List<Consulta> findByUsuRegistra(String usuario);
	
	List<Consulta> findByClientePersonaPersonaPerTelefono(String telefono);
}
