/**
 * 
 */
package com.medico.home.admon.cuestionario.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.cuestionario.model.Seccion;
import com.medico.home.commons.cuestionario.model.TipoSecc;

/**
 * @author macpro
 *
 */
public interface ITipoSeccDAO extends PagingAndSortingRepository<TipoSecc, Long> {
	
	@Query("SELECT tpo.seccion FROM TipoSecc tpo WHERE tpo.tpcId = ?1")
	List<Seccion> getLstSeccByTpoCue(Integer tipoCue);

}
