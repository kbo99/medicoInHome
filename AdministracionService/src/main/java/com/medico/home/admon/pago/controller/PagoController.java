/**
 * 
 */
package com.medico.home.admon.pago.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.admon.pago.service.IFormaPago;
import com.medico.home.admon.pago.service.IPago;
import com.medico.home.admon.pago.service.IPagoEstatus;
import com.medico.home.admon.pago.service.ITipoPago;
import com.medico.home.commons.pago.model.FormaPago;
import com.medico.home.commons.pago.model.Pago;
import com.medico.home.commons.pago.model.PagoEstatus;
import com.medico.home.commons.pago.model.TipoPago;
import com.medico.home.commons.util.Const;
import com.medico.home.commons.util.IconAlert;
import com.medico.home.commons.util.Response;

/**
 * @author rgarciaq
 *
 */
@RestController
@RequestMapping("/pago")
public class PagoController {
	
	@Autowired
	IPago pagoService;
	
	@Autowired
	ITipoPago tipoPagoService;
	
	@Autowired
	IPagoEstatus pagoEstatusService;
	
	@Autowired
	IFormaPago formaPagoService;

	
	@PostMapping("/addTpoPago")
	public ResponseEntity<Response> addTpoPago(@RequestBody TipoPago tpoPago){
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(tipoPagoService.save(tpoPago));
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al agregar tipo de pago");
			response.setTitle("Error");
		}

		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/addPago")
	public ResponseEntity<Response> addPago(@RequestBody Pago pago){
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(pagoService.save(pago));
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al buscar las ventas activas");
			response.setTitle("Error");
		}

		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/tpoPagoByEstatus")
	public ResponseEntity<Response> findTpoPagoByEstatus(@RequestBody String estatusTpo){
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(tipoPagoService.findByEstatus(estatusTpo));
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al buscar las ventas activas");
			response.setTitle("Error");
		}

		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/frmPagoByEstatus")
	public ResponseEntity<Response> findFmrPagoByEstatus(@RequestBody String estatusFrm){
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(formaPagoService.findByEstatus(estatusFrm));
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al buscar las ventas activas");
			response.setTitle("Error");
		}

		return new ResponseEntity<Response>(response, estatus);
	}
	
	
	@PostMapping("/findEstaPagoByEstatus")
	public ResponseEntity<Response> findEstaPagoByEstatus(@RequestBody String estatusFrm){
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(pagoEstatusService.findByEstatus(estatusFrm));
			
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al buscar las ventas activas");
			response.setTitle("Error");
		}

		return new ResponseEntity<Response>(response, estatus);
	}

	
	
	@PostMapping("/saveTipoPago")
	public ResponseEntity<Response> saveTipoPago(@RequestBody TipoPago tpoPago) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			tipoPagoService.save(tpoPago);
			response.setTypeMessage(IconAlert.SUCCESS);
			response.setMessage("Tipo de Pago Agregado correctamente");
			response.setResponse(tipoPagoService.findByEstatus(Const.ESTATUS_ACTIVO));
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al buscar las ventas activas");
			response.setTitle("Error");
		}

		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/saveFrmPago")
	public ResponseEntity<Response> saveFrmPago(@RequestBody FormaPago tpoPago) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			formaPagoService.save(tpoPago);
			response.setTypeMessage(IconAlert.SUCCESS);
			response.setMessage("La Forma Pago Agregado correctamente");
			response.setResponse(formaPagoService.findByEstatus(Const.ESTATUS_ACTIVO));
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al buscar las ventas activas");
			response.setTitle("Error");
		}

		return new ResponseEntity<Response>(response, estatus);
	}
	
	
	@PostMapping("/saveEstPago")
	public ResponseEntity<Response> saveEstPago(@RequestBody PagoEstatus PagoEstatus) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			PagoEstatus.setPgsDefault(Const.STRING_F);
			pagoEstatusService.save(PagoEstatus);
			response.setTypeMessage(IconAlert.SUCCESS);
			response.setMessage("El Estatus de Pago Agregado correctamente");
			response.setResponse(pagoEstatusService.findByEstatus(Const.ESTATUS_ACTIVO));
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al buscar las ventas activas");
			response.setTitle("Error");
		}

		return new ResponseEntity<Response>(response, estatus);
	}
	

	
	
	
	
}
