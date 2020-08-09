/**
 * 
 */
package com.medico.home.admon.persona.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.admon.cliente.service.IClienteService;
import com.medico.home.admon.membresia.service.IMembresiaAdmonService;
import com.medico.home.admon.persona.service.IPersonaAdmonService;
import com.medico.home.commons.cliente.model.Cliente;
import com.medico.home.commons.cliente.model.ClientePersona;
import com.medico.home.commons.doctor.model.Doctor;
import com.medico.home.commons.membresia.model.MembresiaCliente;
import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.util.IconAlert;
import com.medico.home.commons.util.MedicBusinessException;
import com.medico.home.commons.util.Response;

/**
 * @author macpro
 *
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IPersonaAdmonService personaAdmonService;
	
	@Autowired
	IMembresiaAdmonService membresiaAdmonService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> generaNuevoCliente(@RequestBody Persona persona) throws Exception{
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(clienteService.generaNuevoCliente(persona));
			response.setMessage("el Usuario  " + persona.getPerNombre() + " se guardo correctamente");
			response.setTitle("Usuario Guardado");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch (MedicBusinessException e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError(e.getErrorMessage());
			response.setTitle("Error");
		} catch(Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar usuario");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/registerDoc")
	public Doctor generaNuevoDoctor(@RequestBody Doctor persona) throws Exception{
		Doctor docTpm = null;
		try {
			docTpm = personaAdmonService.registraNuevo(persona);
		} catch (Exception e) {
			//se dispara nueva expecion, aun no bien controlada xd 
			//pero asi ya no llega a la vista el error
			throw new Exception();
		}
		return docTpm; 
	}
	
	@PostMapping("/registerBen")
	public ClientePersona generaNuevoBeneficiario(@RequestBody ClientePersona persona) throws Exception{
		
		try {
			persona = clienteService.generaClienteBene(persona);
		} catch (Exception e) {
			//se dispara nueva expecion, aun no bien controlada xd 
			//pero asi ya no llega a la vista el error
			throw new Exception();
		}
		return persona; 
	}
	
	@PostMapping("/memCliente")
	public MembresiaCliente membresiaClienteByUser(@RequestBody String persona) throws Exception{
		MembresiaCliente mem = new MembresiaCliente();
		try {
			mem = membresiaAdmonService.getMembresiaByUser(persona);
		} catch (Exception e) {
			//se dispara nueva expecion, aun no bien controlada xd 
			//pero asi ya no llega a la vista el error
			throw new Exception();
		}
		return mem; 
	}
	
	
	@PostMapping("/misbene")
	 public List<ClientePersona> getMisBeneficiarios(@RequestBody String usuer) throws Exception {
		 List<ClientePersona> mem = new ArrayList<ClientePersona>();
			try {
				mem = clienteService.getMisBeneficiarios(usuer);
			} catch (Exception e) {
				//se dispara nueva expecion, aun no bien controlada xd 
				//pero asi ya no llega a la vista el error
				throw new Exception();
			}
			return mem; 
	 }
}
