/**
 * 
 */
package com.medico.home.admon.membresia.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.admon.cliente.service.IClienteService;
import com.medico.home.admon.membresia.dao.IBeneficioDAO;
import com.medico.home.admon.membresia.dao.IMembresiaBeneficioDAO;
import com.medico.home.admon.membresia.dao.IMembresiaClienteDAO;
import com.medico.home.admon.membresia.dao.IMembresiaDAO;
import com.medico.home.admon.membresia.dao.IMovimientoMembresiaDAO;
import com.medico.home.commons.beneficio.model.Beneficio;
import com.medico.home.commons.cliente.model.ClientePersona;
import com.medico.home.commons.membresia.model.Membresia;
import com.medico.home.commons.membresia.model.MembresiaBeneficio;
import com.medico.home.commons.membresia.model.MembresiaCliente;
import com.medico.home.commons.membresia.model.MovimientoMembresia;
import com.medico.home.commons.membresia.model.TipoMovimientoMembresia;
import com.medico.home.commons.util.Const;

/**
 * @author macpro 
 *
 */
@Service
public class MembresiaAdmonService implements IMembresiaAdmonService {
	
	Logger logger = LoggerFactory.getLogger(MembresiaAdmonService.class);
	
	@Autowired
	IBeneficioDAO beneficioDAO;
	
	@Autowired
	IMembresiaDAO membresiaDAO;
	
	@Autowired
	IMembresiaClienteDAO membresiaClienteDAO;
	
	@Autowired
	IMovimientoMembresiaDAO movimientoMembresiaDAO;
	
	@Autowired
	IMembresiaBeneficioDAO membresiaBeneficioDAO;
	
	@Autowired
	private IClienteService clienteService;
	

	@Override
	public Beneficio save(Beneficio beneficio) throws Exception {
		try {
			beneficio = beneficioDAO.save(beneficio);
		} catch (Exception e) {
			logger.error("Error al guardar/actualixar beneficio", e);
			throw new Exception(e);
		}
		return beneficio;
	}

	@Override
	public Beneficio nuevoBeneficio(Beneficio beneficio) throws Exception {
		try {
			beneficio.setBenEstatus(Const.ESTATUS_ACTIVO);
			beneficio.setBenFregistra(new Date());
			beneficio = save(beneficio);
		} catch (Exception e) {
			logger.error("Error al generar beneficio", e);
			throw new Exception(e);
		}
		return beneficio; 
	}

	@Override
	public List<Beneficio> findBeneficioByBenEstatus(String benEstatus) throws Exception {
		List<Beneficio> lstBen = null;
		try {
			lstBen = beneficioDAO.findByBenEstatus(benEstatus);
		} catch (Exception e) {
			logger.error("Error al buscar beneficios by estatus"+ benEstatus, e);
			throw new Exception(e);
		}
		return lstBen;
	}

	@Override
	public List<Beneficio> getBeneficioAdmonMembresia(List<Integer> lstBenId, String estatus) throws Exception {
		List<Beneficio> lstBen = null;
		try {
			lstBen = beneficioDAO.getBeneficioAdmonMembresia(lstBenId, estatus);
		} catch (Exception e) {
			logger.error("Error al buscar beneficios asignados a memebresia by estatus"+ estatus, e);
			throw new Exception(e);
		}
		return lstBen;
	}

	@Override
	public Membresia save(Membresia membresia) throws Exception {
		try {
			membresia = membresiaDAO.save(membresia);
		} catch (Exception e) {
			logger.error("Error al guardar memebresia", e);
			throw new Exception(e);
		}
		return membresia;
	}

	@Override
	public Membresia nueva( Membresia membresia) throws Exception {
		
		try {
			membresia.setMemEstatus(Const.ESTATUS_ACTIVO);
			membresia.setMemFcreacion(new Date());
			List<Beneficio> lstTmp = membresia.getBeneficios();
			
			membresia = save(membresia);
			membresia.setBeneficios(lstTmp);
			final Membresia membresiaTmp = membresia;
			membresia.getBeneficios().forEach(item-> {
				MembresiaBeneficio tmp = new MembresiaBeneficio();
				tmp.setBeneficio(item);
				tmp.setMembresia(membresiaTmp);
				tmp.setMebEstatus(Const.ESTATUS_ACTIVO);
				membresiaBeneficioDAO.save(tmp);
			});
		} catch (Exception e) {
			logger.error("Error al guardar memebresia", e);
			throw new Exception(e);
		}
		return membresia;
	}

	
	@Override
	public MembresiaCliente save(MembresiaCliente clienPer) throws Exception {
		try {
			clienPer.setMecFultimaMod(new Date());
			clienPer = membresiaClienteDAO.save(clienPer);
		} catch (Exception e) {
			logger.error("Error al MembresiaCliente", e);
			throw new Exception(e);
		}
		return clienPer;
	}

	@Override
	public MovimientoMembresia generaMovimiento(MembresiaCliente memCli, Integer tpoMov) throws Exception {
		MovimientoMembresia mm = null;
		try {
			//Se guarda la membresia
			save(memCli);
			
			//Se genera el tpo movimiento
		    mm = new MovimientoMembresia();
			mm.setMembresiaCliente(memCli);
			mm.setMomFmodficiacion(new Date());
			mm.setTipoMovimientoMembresia(new TipoMovimientoMembresia());
			mm.getTipoMovimientoMembresia().setTmmId(tpoMov);
			mm.setUsuModifica("TITULAR");
			mm = movimientoMembresiaDAO.save(mm);
			
		} catch (Exception e) {
			logger.error("Error al MembresiaCliente", e);
			throw new Exception(e);
		}
		return mm;
	}

	@Override
	public MembresiaCliente save(ClientePersona clienPer, Integer tpoMov) throws Exception {
		MembresiaCliente mc = null;
		try {
			mc = new MembresiaCliente();
			mc.setClientePersona(clienPer);
			mc.setMembresia(new Membresia());
			mc.getMembresia().setMemId(clienPer.getPersona().getMembresia());
			mc.setMecEstatus(Const.ESTATUS_ACTIVO);
			mc.setMecFinicio(new Date());
			mc.setMecFvencimiento(0);
			mc.setMecDuracion(0);
			//si es el totular se agina el folio nuevo, caso contrario consultamos el folio del titular y se asigna
			//Se genera folio con el memId y con el perId mas 00 y M para que se vea loco
				mc.setMecFolio(clienPer.getPerfilPersonaCliente().getPpcId() == Const.PERFIL_PER_TITULAR ? 
						"00"+clienPer.getPersona().getMembresia()+"00"+clienPer.getPersona().getPerId()+"M" :
					membresiaClienteDAO.findByClientePersonaClienteCliIdAndClientePersonaPerfilPersonaClientePpcId(
							clienPer.getCliente().getCliId(), Const.PERFIL_PER_TITULAR).getMecFolio());
			
			
			mc = generaMovimiento(mc, tpoMov).getMembresiaCliente();
			
		} catch (Exception e) {
			logger.error("Error al MembresiaCliente", e);
			throw new Exception(e);
		}
		return mc;
	}

	
	@Override
	public List<MembresiaCliente> getMisMembresias(String usuario) throws Exception {
		List<MembresiaCliente> lstTmp = new ArrayList<MembresiaCliente>();
		try {
			//buscamos las membresias del cliente se amarra por el telefono que es el usuario 
		//	lstTmp = membresiaClienteDAO.findByClientePersonaPersonaPerTelefono(usuario);
		} catch (Exception e) {
			logger.error("Error al buscar Membresias del Cliente", e);
			throw new Exception(e);
		}
		return lstTmp;
	}

	@Override
	public MembresiaCliente getMembresiaByUser(String user) throws Exception {
		MembresiaCliente membresia = new MembresiaCliente();
		try {
			String userCon = user.substring(1, 11);
			membresia =  membresiaClienteDAO.findByClientePersonaPersonaPerTelefono(userCon);
			membresia.getMembresia().setBeneficios(membresiaBeneficioDAO.getBeneficiosBymm(membresia.getMembresia().getMemId()));
			
		} catch (Exception e) {
			logger.error("Error al buscar Membresias del Cliente", e);
			throw new Exception(e);
		}
		return membresia;
	}
	
	
	@Override
	public List<Membresia> findAllByMem()  throws Exception {
		 List<Membresia> lstM = membresiaDAO.findByMemEstatus("AC");
		 lstM.forEach(item -> {
			 item.setBeneficios(membresiaBeneficioDAO.getBeneficiosBymm(item.getMemId()));
		 });
		 
		 return lstM;
	}

	@Override
	public List<MovimientoMembresia> findMovAllByMem(String mecFolio) throws Exception {
		List<MovimientoMembresia>  lstMov = new ArrayList<MovimientoMembresia>();
		try {
			movimientoMembresiaDAO.findByMembresiaClienteMecFolio(mecFolio).forEach(item -> {
				lstMov.add(item);
			});
			
		} catch (Exception e) {
			logger.error("Error al buscar Membresias del Cliente", e);
			throw new Exception(e);
		}
		
		return lstMov;
	}

	@Override
	public List<Beneficio> findBeneficioByUser(String username) throws Exception {
		List<Beneficio>  lstMov = new ArrayList<Beneficio>();
		try {
			lstMov = findBeneficioByBenEstatus(Const.ESTATUS_ACTIVO);
			
		} catch (Exception e) {
			logger.error("Error al buscar Membresias del Cliente", e);
			throw new Exception(e);
		}
		
		return lstMov;
	}

	@Override
	public Membresia getMembresia(String user) throws Exception {
		ClientePersona perTmp = clienteService.findByPersonaPerTelefono(user);
		List<MembresiaCliente> lstMem = membresiaClienteDAO.
				findByClientePersonaClienteCliId(perTmp.getCliente().getCliId());
		Membresia mem;
		if(lstMem != null && lstMem.size() > 0) {
			mem = lstMem.get(0).getMembresia();
		}else {
			mem = new Membresia();
		}
		return mem;
	}

}
