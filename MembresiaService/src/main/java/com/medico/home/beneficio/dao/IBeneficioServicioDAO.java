/**
 * 
 */
package com.medico.home.beneficio.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.beneficio.model.BeneficioServicio;

/**
 * @author rgarciaq
 *
 */

@RepositoryRestResource(path = "ben-ser")
public interface IBeneficioServicioDAO extends PagingAndSortingRepository<BeneficioServicio, Long> {

	List<BeneficioServicio> findByBeneficioDetalleBeneficioBenId(Integer benId);
	
	List<BeneficioServicio> findByTipoServicioTpsId(Integer serId);
	
	List<BeneficioServicio> findByBeneficioDetalleBeneficioBenIdAndTipoServicioTpsId(Integer benId, Integer serId);
	
	List<BeneficioServicio> findByBeneficioDetalleBeneficioBenNombre(String benNombre);
	
	List<BeneficioServicio> findByTipoServicioTpsNombre(String serId);
	
}
