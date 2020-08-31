/**
 * 
 */
package com.medico.home.admon.servicio.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.medico.home.commons.servicio.model.TipoServicio;

/**
 * @author macpro
 *
 */
@RepositoryRestResource(path = "tpo-serv")
public interface ITipoServicioDAO extends PagingAndSortingRepository<TipoServicio, Long> {
	
	TipoServicio save(TipoServicio tpoSer);
	
	@RestResource(path = "busca-serv-act")
	public List<TipoServicio> findByTpsEstatus(@RequestParam String estatus);
	
	
	

}
