/**
 * 
 */
package com.medico.home.admon.producto.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.producto.model.TipoProducto;

/**
 * @author macpro
 *
 */
@RepositoryRestResource(path = "tpo-prod")
public interface ITipoProductoDAO extends PagingAndSortingRepository<TipoProducto, Long> {
	
	TipoProducto save(TipoProducto tipoProducto);
	
	List<TipoProducto> findByTpoprodEstatus(String estatus);
	
	

}
