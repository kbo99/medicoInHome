/**
 * 
 */
package com.medico.home.admon.cuestionario.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.cuestionario.model.Pregunta;
import com.medico.home.commons.cuestionario.model.ResHija;

/**
 * @author macpro
 *
 */
public interface IResHijaDAO extends PagingAndSortingRepository<ResHija, Long> {
	
	@Query("SELECT pre.pregunta FROM ResHija pre WHERE pre.respuesta.resId = ?1 ")
	List<Pregunta> getPreguntaByResPade(Integer resId);

}
