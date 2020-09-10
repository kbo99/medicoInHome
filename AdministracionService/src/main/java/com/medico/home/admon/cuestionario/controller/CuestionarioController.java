/**
 * 
 */
package com.medico.home.admon.cuestionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.admon.cuestionario.service.ICuestionario;
import com.medico.home.commons.cuestionario.model.Cuestionario;
import com.medico.home.commons.util.Const;
import com.medico.home.commons.util.IconAlert;
import com.medico.home.commons.util.Response;

/**
 * @author macpro
 *
 */
@RestController
@RequestMapping("/cuest")
public class CuestionarioController {
	
	@Autowired
	private ICuestionario cuestionarioService;

	
	@PostMapping("/historial")
	public ResponseEntity<Response> historial(@RequestBody Integer cpeId) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(cuestionarioService.getCuestionarioByCpeIdAndTpoCues(cpeId,
					Const.TIPO_CUES_HISTORIAL));
			response.setMessage("");
			response.setTitle("");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al construir historial");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	
	@PostMapping("/svhistorial")
	public ResponseEntity<Response> generaNuevo(@RequestBody Cuestionario cuest) {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(cuestionarioService.generaNuevo(cuest));
			response.setMessage("Historial Guardado con Exito");
			response.setTitle("Success");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al construir historial");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
}
