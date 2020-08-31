/**
 * 
 */
package com.medico.home.admon.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.medico.home.admon.producto.service.IProducto;
import com.medico.home.commons.producto.model.TipoProducto;

/**
 * @author macpro
 *
 */
@RestController
public class ProductoController {
	
	@Autowired
	IProducto productoService;
	

	
	@PostMapping("/guardartpo")
	public TipoProducto save(@RequestBody TipoProducto tpoProd) throws Exception{
		return productoService.saveNw(tpoProd);
	}
	
	
	@PostMapping("/listartpo")
	public List<TipoProducto> findByTpsEstatus(@RequestBody String estatus) throws Exception{
		return productoService.findByTpoProdEstatus(estatus);
	}
	
	@PostMapping("/updatetpo")
	public TipoProducto update(@RequestBody TipoProducto tpoProd) throws Exception{
		return productoService.save(tpoProd);
	}
	
	

}
