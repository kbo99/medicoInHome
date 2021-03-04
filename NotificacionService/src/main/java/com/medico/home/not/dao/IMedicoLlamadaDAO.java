/**
 * 
 */
package com.medico.home.not.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.medico.home.not.model.MedicoLlamada;

/**
 * @author macpro
 *
 */
@Repository
public interface IMedicoLlamadaDAO extends PagingAndSortingRepository<MedicoLlamada, Integer> {
	
	MedicoLlamada save(MedicoLlamada medicoLlamada);
	
	MedicoLlamada findByLlpIdAndUserMedico(int llpId, String user);
	
	List<MedicoLlamada> findByUserMedicoAndMllEstatus(String user, String status);

}
