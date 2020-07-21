/**
 * 
 */
package com.medico.home.admon.persona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.admon.cliente.service.IClienteService;
import com.medico.home.commons.cliente.model.Cliente;
import com.medico.home.commons.persona.model.Persona;

/**
 * @author macpro
 *
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	IClienteService clienteService;
	
	@PostMapping("/register")
	public Cliente generaNuevoCliente(@RequestBody Persona persona) throws Exception{
		Cliente cliTpm = null;
		try {
			cliTpm = clienteService.generaNuevoCliente(persona);
		} catch (Exception e) {
			//se dispara nueva expecion, aun no bien controlada xd 
			//pero asi ya no llega a la vista el error
			throw new Exception();
		}
		return cliTpm; 
	}
}
