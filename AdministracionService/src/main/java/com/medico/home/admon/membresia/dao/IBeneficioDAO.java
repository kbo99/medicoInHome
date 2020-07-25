/**
 * 
 */
package com.medico.home.admon.membresia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.medico.home.commons.beneficio.model.Beneficio;


/**
 * @author rgarciaq
 *
 */
@RepositoryRestResource(path = "bene")
public interface IBeneficioDAO extends PagingAndSortingRepository<Beneficio, Long> {

	/**
	 * Filtra los beneficios por estatus
	 * @param benStatus
	 * @return
	 */
	@RestResource(path = "busca-ben-by-est")
	List<Beneficio> findByBenEstatus(String benStatus);
	
	/**
	 * Filtra los beneficios por nombre
	 * @param benNombre
	 * @return
	 */
	@RestResource(path = "busca-ben-by-nom")
	List<Beneficio> findByBenNombre(String benNombre);
	
	/**
	 * Filtra los beneficios por nombre y estatus
	 * @param benNombre
	 * @param benStatus
	 * @return
	 */
	@RestResource(path = "busca-ben-by-nomest")
	List<Beneficio> findByBenNombreAndBenEstatus(String benNombre, String benStatus);
	
	/**
	 * Filtra los beneficios por un like 
	 * @param benNombre
	 * @return
	 */
	@RestResource(path = "busca-ben-by-likeno")
	List<Beneficio> findByBenNombreLike(String benNombre);
	
	@Query("SELECT ben FROM Beneficio ben WHERE ben.benId NOT IN (?1) AND ben.benEstatus = ?2")
	List<Beneficio> getBeneficioAdmonMembresia(List<Integer> lstBenId, String estatus);
	
}
