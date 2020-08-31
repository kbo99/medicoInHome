/**
 * 
 */
package com.medico.home.admon.producto.service;

import java.util.List;

import com.medico.home.commons.producto.model.TipoProducto;

/**
 * @author macpro
 *
 */
public interface IProducto {
	
	TipoProducto save(TipoProducto tpoProd) throws Exception;
	
	List<TipoProducto> findByTpoProdEstatus(String estatus) throws Exception;
	
	TipoProducto saveNw(TipoProducto tpoProd) throws Exception;

}
