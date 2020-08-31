/**
 * 
 */
package com.medico.home.beneficio.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.membresia.model.MovimientoBeneficioMem;

/**
 * @author rgarciaq
 *
 */
@RepositoryRestResource(path = "benemov")
public interface IBeneficioMovimientoDAO extends PagingAndSortingRepository<MovimientoBeneficioMem, Long> {

	/**
	 * LIsta de movimientos de los beneficios de la membresia a travez de Membresia cliente id
	 * @param mecId Membresia cliente id
	 * @return
	 */
	List<MovimientoBeneficioMem> findByMembresiaClienteMecId(Integer mecId);

	/**
	 * LIsta de movimientos de los beneficios de la membresia a traves del cliente id
	 * @param cliId  cliente id
	 * @return
	 */
	List<MovimientoBeneficioMem> findByMembresiaClienteClientePersonaClienteCliId(Integer clienteId);

	/**
	 * LIsta de movimientos de los beneficios de la membresia a traves del cliente inombre
	 * @param cliNom nombre corto cliente
	 * @return
	 */
	List<MovimientoBeneficioMem> findByMembresiaClienteClientePersonaClienteCliNomCorto(String nombre);

	/**
	 * LIsta de movimientos de los beneficios de la membresia  a traves del cliente id y de Membresia cliente ids
	 * @param mecId Membresia cliente id
	 *  @param cliId  cliente id
	 * @return
	 */
	List<MovimientoBeneficioMem> findByMembresiaClienteMecIdAndMembresiaClienteClientePersonaClienteCliId(Integer mecId,Integer cliId);

	/**
	 * LIsta de movimientos de los beneficios de la membresia  a traves del cliente nombre y de Membresia cliente ids
	 * @param mecId Membresia cliente id
	 *  @param clienNombre  cliente nombre corto
	 * @return
	 */
	List<MovimientoBeneficioMem> findByMembresiaClienteMecIdAndMembresiaClienteClientePersonaClienteCliNomCorto(Integer mecId, String clienNombre);
	
	/**
	 * LIsta de movimientos de beneficios de la membresia a partir de la persona
	 * @param perId id persona
	 * @return
	 */
	List<MovimientoBeneficioMem> findByMembresiaClienteClientePersonaPersonaPerId(Integer perId);
	
	/**
	 * LIsta de movimientos de beneficios de la membresia a partir de la persona y la membresia cliente
	 * @param mecId  Membresia cliente id
	 * @param perId id persona
	 * @return
	 */
	List<MovimientoBeneficioMem> findByMembresiaClienteMecIdAndMembresiaClienteClientePersonaPersonaPerId(Integer mecId, Integer perId);

}
