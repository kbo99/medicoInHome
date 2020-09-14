/**
 * 
 */
package com.medico.home.admon.cliente.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.medico.home.admon.cliente.dao.IClienteDAO;
import com.medico.home.admon.cliente.dao.IClientePersonaDAO;
import com.medico.home.admon.membresia.service.IMembresiaAdmonService;
import com.medico.home.admon.persona.service.IPersonaAdmonService;
import com.medico.home.commons.cliente.model.Cliente;
import com.medico.home.commons.cliente.model.ClientePersona;
import com.medico.home.commons.cliente.model.PerfilPersonaCliente;
import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.util.Const;
import com.medico.home.commons.util.MedicBusinessException;

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
	
	@Autowired
	IMembresiaAdmonService membresiaAdmonService;
	
	
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

			//Se crea el perfil de cliente
			List<Grupo> lstGrp = new ArrayList<Grupo>();
			Grupo grp = new Grupo();
			grp.setGrpId(Const.PERFIL_USU_CLIENTE_TITULAR);
			lstGrp.add(grp);
			//Se manda a generar nueva persona y usuario
			persona = personaService.registraNueva(persona, lstGrp);
			//se guarda el cliente.
			clienTmp = save(clienTmp);
			//Se manda a generar el cliente persona como titular
			generaClientePersona(clienTmp, persona, Const.PERFIL_PER_TITULAR);
		
		} catch (MedicBusinessException e) {
			throw (e);
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
			Integer membresoa = persona.getMembresia();
			//se arma el cliente persona
			cp.setCliente(cliente);
			cp.setPersona(persona);
			cp.setPerfilPersonaCliente(new PerfilPersonaCliente());
			cp.getPerfilPersonaCliente().setPpcId(perfId);
			cp.setCpeFregistro(new Date());
			// se manda a generar el nuevo cliente persona
			cp = save(cp);
			
			//Se le cuelga su membresia
			cp.getPersona().setMembresia(membresoa);
			membresiaAdmonService.save(cp, perfId == Const.PERFIL_PER_BENE ? Const.MOV_MEM_ADD_NEW_BENE :
				Const.MOV_MEM_ADD_NEW);
			
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

	@Override
	public ClientePersona generaClienteBene(ClientePersona persona) throws Exception {
		
		try {
			List<Grupo> lstGrp = new ArrayList<Grupo>();
			Grupo grp = new Grupo();
			grp.setGrpId(Const.PERFIL_USU_CLIENTE_BENE);
			lstGrp.add(grp);
			persona.getPersona().setPassword(persona.getPersona().getPerNombre().substring(0,2)+
					persona.getPersona().getPerApePate().substring(0,2)+persona.getPersona().getPerTelefono().substring(0,4));
			//Se manda a generar nueva persona y usuario
			persona.setPersona(personaService.registraNueva(persona.getPersona(), lstGrp));
			
			//Se manda a generar el cliente persona como beneficiario
			persona = generaClientePersona(persona.getCliente(), persona.getPersona(), Const.PERFIL_PER_BENE);
		} catch (Exception e) {
			logger.error("Error al generar el  nuevo cliente beneficiario",e);
			throw new Exception(e);
		}
		return persona;
	}

	@Override
	public List<ClientePersona> getMisBeneficiarios(String usuer) throws Exception {
		List<ClientePersona> lstBen = new ArrayList<ClientePersona>();
		try {
			ClientePersona clitmp = clientePersonaDAO.findByPersonaPerTelefonoAndPerfilPersonaClientePpcId(usuer, 
					Const.PERFIL_PER_TITULAR);
			lstBen = clientePersonaDAO.findByClienteCliIdAndPerfilPersonaClientePpcId(clitmp.getCliente().getCliId(),
					Const.PERFIL_PER_BENE);      
		} catch (Exception e) {
			logger.error("Error al generar el  nuevo cliente beneficiario",e);
			throw new Exception(e);
		}
		return lstBen;
	}

	@Override
	public List<ClientePersona> findallClientePersona() {
		List<ClientePersona> result = new ArrayList<ClientePersona>();
		clientePersonaDAO.findByPerfilPersonaClientePpcId(Const.PERFIL_PER_TITULAR).forEach(a -> result.add(a));
		return result;
	}

	@Override
	public ClientePersona findByCpeId(Integer cpeId) throws Exception {
		ClientePersona cliente;
		try {
			cliente = clientePersonaDAO.findByCpeId(cpeId);
		} catch (Exception e) {
			logger.error("Error al generar el  nuevo cliente beneficiario",e);
			throw new Exception(e);
		}
		return null;
	}




}
