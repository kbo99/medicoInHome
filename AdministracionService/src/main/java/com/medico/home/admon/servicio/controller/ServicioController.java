/**
 * 
 */
package com.medico.home.admon.servicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.admon.membresia.service.IMembresiaAdmonService;
import com.medico.home.admon.servicio.service.IServicio;
import com.medico.home.commons.beneficio.model.Beneficio;
import com.medico.home.commons.membresia.model.Membresia;
import com.medico.home.commons.servicio.model.TipoServicio;
import com.medico.home.commons.util.Const;
import com.medico.home.commons.util.IconAlert;
import com.medico.home.commons.util.Response;

/**
 * @author macpro
 *
 */
@RestController
public class ServicioController {
	
	@Autowired
	private IServicio servicioService;
	
	@Autowired
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
	
	@PostMapping("/findByBenEstatus")
	public List<Beneficio> findByBenEstatus(@RequestBody String benEstatus) throws Exception{
		return membresiaAdmonService.findBeneficioByBenEstatus(benEstatus);	
	}
	
	@PostMapping("/findByBenMemAdmon")
	public List<Beneficio> findByBenEstatus(@RequestBody List<Integer> benEstatus) throws Exception{
		return membresiaAdmonService.getBeneficioAdmonMembresia(benEstatus, Const.ESTATUS_ACTIVO);
	}
	

	@PostMapping("/guardarMem")
	public ResponseEntity<Response> detalle(@RequestBody Membresia tpoSer) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(membresiaAdmonService.nueva(tpoSer));
			response.setMessage("La Membresia  se guardo correctamente");
			response.setTitle("");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar Perona");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}

	@PostMapping("/findAllTipoMem")
	public ResponseEntity<Response>  findAllMem() {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(membresiaAdmonService.findAllByMem());
			response.setMessage("");
			response.setTitle("");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar Perona");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	
	@PostMapping("/findMovMem")
	public ResponseEntity<Response> findMovMem(@RequestBody String mecFolio) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(membresiaAdmonService.findMovAllByMem(mecFolio));
			response.setMessage("");
			response.setTitle("");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar Perona");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
}
