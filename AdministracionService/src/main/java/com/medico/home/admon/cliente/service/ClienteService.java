/**
 * 
 */
package com.medico.home.admon.cliente.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.admon.cliente.dao.IClienteDAO;
import com.medico.home.admon.cliente.dao.IClientePersonaDAO;
import com.medico.home.admon.persona.service.IPersonaAdmonService;
import com.medico.home.commons.cliente.model.Cliente;
import com.medico.home.commons.cliente.model.ClientePersona;
import com.medico.home.commons.cliente.model.PerfilPersonaCliente;
import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.util.Const;

/**
 * @author macpro
 *
 */
@Service
public class ClienteService implements IClienteService {

	Logger logger = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	IClienteDAO clienteDAO;
	
	@Autowired
	IClientePersonaDAO clientePersonaDAO;
	
	@Autowired
	IPersonaAdmonService personaService;
	
	
	@Override
	public Cliente save(Cliente cliente) throws Exception {
		try {
			cliente.setCliFultimaOp(new Date());
			cliente = clienteDAO.save(cliente);
		} catch (Exception e) {
			logger.error("Error al guardar/actualizar el  cliente ",e);
			throw new Exception(e);
		}
		return cliente;
	}

	/**
	 * Metodo encargado de generar un nuevo cliente
	 */
	@Override
	public Cliente generaNuevoCliente(Persona persona) throws Exception {
		Cliente clienTmp = new Cliente();
		try {
			//Se genera el cliente con los datos minimos
			clienTmp.setCliNomCorto(persona.getPerNombre() + " " + persona.getPerApePate());
			clienTmp.setCliFregistro(new Date());
			clienTmp.setCliEstatus(Const.ESTATUS_ACTIVO);
			
			//Se manda a generar nueva persona y usuario
			persona = personaService.registraNueva(persona);
			//se guarda el cliente.
			clienTmp = save(clienTmp);
			//Se manda a generar el cliente persona como titular
			generaClientePersona(clienTmp, persona, Const.PERFIL_PER_TITULAR);
		} catch (Exception e) {
			logger.error("Error al generar el  nuevo cliente ",e);
			throw new Exception(e);
		}
		return clienTmp;
	}

	/**
	 * Metodo encargado de generar el cliente persona
	 */
	@Override
	public ClientePersona generaClientePersona(Cliente cliente, Persona persona, Integer perfId) throws Exception {
		ClientePersona cp = new ClientePersona();
		try {
			
			//se arma el cliente persona
			cp.setCliente(cliente);
			cp.setPersona(persona);
			cp.setPerfilPersonaCliente(new PerfilPersonaCliente());
			cp.getPerfilPersonaCliente().setPpcId(perfId);
			cp.setCpeFregistro(new Date());
			// se manda a generar el nuevo cliente persona
			cp = save(cp);
			
		} catch (Exception e) {
			logger.error("Error al generar el  nuevo cliente persona",e);
			throw new Exception(e);
		}
		return cp;
	}

	/**
	 * Metodo encargado de guardar/actualizar cliente persona
	 */
	@Override
	public ClientePersona save(ClientePersona clienPer) throws Exception {
		try {
			clienPer.setCpeFultimaMod(new Date());
			clienPer = clientePersonaDAO.save(clienPer);
			
		} catch (Exception e) {
			logger.error("Error al guardar/actualizar el  cliente persona",e);
			throw new Exception(e);
		}
		return clienPer;
	}

}
