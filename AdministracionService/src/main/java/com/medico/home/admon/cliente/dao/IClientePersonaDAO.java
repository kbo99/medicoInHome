/**
 * 
 */
package com.medico.home.admon.cliente.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.cliente.model.ClientePersona;

/**
 * @author macpro
 *
 */
public interface IClientePersonaDAO extends PagingAndSortingRepository<ClientePersona, Long> {

}
