/**
 * 
 */
package com.medico.home.admon.producto.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.producto.model.Producto;

/**
 * @author macpro
 *
 */
public interface IProductoDAO extends PagingAndSortingRepository<Producto, Long> {
	
	

}
