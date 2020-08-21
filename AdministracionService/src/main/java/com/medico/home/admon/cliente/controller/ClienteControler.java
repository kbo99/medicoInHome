package com.medico.home.admon.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.admon.cliente.service.IClienteService;
import com.medico.home.commons.cliente.model.ClientePersona;

/**
 * 
 * @author kbo99
 *
 */
@RestController
@RequestMapping("/cliente")
public class ClienteControler {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public List<ClientePersona> findallClientePersona() {
		return clienteService.findallClientePersona();
	}
	
}
