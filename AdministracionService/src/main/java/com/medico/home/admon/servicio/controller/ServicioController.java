/**
 * 
 */
package com.medico.home.admon.servicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.admon.membresia.service.IMembresiaAdmonService;
import com.medico.home.admon.servicio.service.IServicio;
import com.medico.home.commons.beneficio.model.Beneficio;
import com.medico.home.commons.servicio.model.TipoServicio;

/**
 * @author macpro
 *
 */
@RestController
public class ServicioController {
	
	@Autowired
	private IServicio servicioService;
	
	private IMembresiaAdmonService membresiaAdmonService;
	
	
	@PostMapping("/guardar")
	public TipoServicio save(@RequestBody TipoServicio tpoSer) throws Exception{
		return servicioService.save(tpoSer);
	}
	
	
	@PostMapping("/listar")
	public List<TipoServicio> findByTpsEstatus(@RequestBody String tpoSer) throws Exception{
		return servicioService.findByTpsEstatus(tpoSer);
	}
	
	@PostMapping("/update")
	public TipoServicio update(@RequestBody TipoServicio tpoSer) throws Exception{
		return servicioService.update(tpoSer);
	}
	
	@PostMapping("/nuevoBeneficio")
	public Beneficio generaNuevo(@RequestBody Beneficio tpoSer) throws Exception{
		return membresiaAdmonService.nuevoBeneficio(tpoSer);	
	}

}
