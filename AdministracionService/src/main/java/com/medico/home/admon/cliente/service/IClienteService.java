package com.medico.home.admon.cliente.service;

import java.util.List;

import com.medico.home.commons.cliente.model.Cliente;
import com.medico.home.commons.cliente.model.ClientePersona;
import com.medico.home.commons.membresia.model.MembresiaCliente;
import com.medico.home.commons.persona.model.Persona;

public interface IClienteService {
	
	Cliente save(Cliente cliente) throws Exception;
	
	Cliente generaNuevoCliente(Persona persona)throws Exception;
	
	ClientePersona generaClientePersona(Cliente cliente, Persona persona, Integer perfId) throws Exception;
	
	ClientePersona save(ClientePersona clienPer) throws Exception;
	
	ClientePersona generaClienteBene(ClientePersona persona) throws Exception;
	
	List<ClientePersona> getMisBeneficiarios(String usuer)throws Exception;

}
