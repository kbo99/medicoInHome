/**
 * 
 */
package com.medico.home.admon.producto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.admon.producto.dao.ITipoProductoDAO;
import com.medico.home.commons.producto.model.TipoProducto;
import com.medico.home.commons.util.Const;

/**
 * @author macpro
 *
 */
@Service
public class ProductoService implements IProducto {
	
	@Autowired
	ITipoProductoDAO tipoProductoDAO;

	/**
	 * 
	 */
	@Override
	public TipoProducto save(TipoProducto tpoProd) throws Exception {
		try {
			tipoProductoDAO.save(tpoProd);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return tpoProd;
	}

	/**
	 * 
	 */
	@Override
	public List<TipoProducto> findByTpoProdEstatus(String estatus) throws Exception {
		List<TipoProducto> lstTpoProd = new ArrayList<TipoProducto>();
		try {
			lstTpoProd = tipoProductoDAO.findByTpoprodEstatus(estatus);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return lstTpoProd;
	}
	
	/**
	 * 
	 */
	@Override
	public TipoProducto saveNw(TipoProducto tpoProd) throws Exception {
		try {
			tpoProd.setTpoprodEstatus(Const.ESTATUS_ACTIVO);
			save(tpoProd);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return tpoProd;
	}

}
