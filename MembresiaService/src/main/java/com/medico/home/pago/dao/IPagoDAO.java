/**
 * 
 */
package com.medico.home.pago.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.pago.model.Pago;

/**
 * @author rgarciaq
 *
 */
@RepositoryRestResource(path = "pago")
public interface IPagoDAO extends PagingAndSortingRepository<Pago, Long> {
	
	/**
	 * Busca el pago por id
	 * @param paoId
	 * @return
	 */
	Pago findByPagId(Integer pagId);
	
	
	/**
	 * Busca pagos por cuenta
	 * @param cueId
	 * @return
	 */
	List<Pago> findByCueId(Integer cueId);
	
	/**
	 * Busca por referencia
	 * @param pagReferencia
	 * @return
	 */
	List<Pago> findByPagReferencia(String pagReferencia);
	
	/**
	 * Busca posibles coincidencias de referencia
	 * @param pagReferencia
	 * @return
	 */
	List<Pago> findByPagReferenciaLike(String pagReferencia);
	
	/**
	 * Busca pagos por fecha limite
	 * @param pagFechaLimite
	 * @return
	 */
	List<Pago> findByPagFechaLimite(Date pagFechaLimite);
	
	/**
	 * Busca pagos por rango de fecha limite
	 * @param pagFechaLimite
	 * @return
	 */
	List<Pago> findByPagFechaLimiteBetween(Date pagFechaLimite, Date pagFechaLimiteFin);

}
