/**
 * 
 */
package com.medico.home.not.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.commons.util.Const;
import com.medico.home.commons.util.Utils;
import com.medico.home.not.dao.ILlamadaPendienteDAO;
import com.medico.home.not.dao.IMedicoLlamadaDAO;
import com.medico.home.not.model.LlamadaPendiente;
import com.medico.home.not.model.MedicoLlamada;

/**
 * @author macpro
 *
 */
@Service
public class LlamadaPendienteService implements ILlamadaPendiente {
	
	
	Logger logger = LoggerFactory.getLogger(LlamadaPendienteService.class);
	
	@Autowired
	ILlamadaPendienteDAO llamdaPendienteDAO;
	
	@Autowired
	IMedicoLlamadaDAO medicoLlamadaDAO;

	@Override
	public LlamadaPendiente save(LlamadaPendiente llamada) throws Exception {
		try {
		 llamada =	llamdaPendienteDAO.save(llamada);
		} catch (Exception e) {
			logger.error("Error al guardar llamada pendiente");
			throw new Exception(e);
		}
		return llamada;
	}


	@Override
	public LlamadaPendiente buildLlamadaPenIni(String usuSol) throws Exception {
		LlamadaPendiente llamadaActiva = new LlamadaPendiente();
		
		llamadaActiva.setUsuSol(usuSol);
		llamadaActiva.setLlpFecha(new Date());
		llamadaActiva.setLlpEstatus(Const.ESTATUS_LLAMADA_X_ATENDER);
		llamadaActiva.setLlpAtendida(Const.STRING_F);
		
		return save(llamadaActiva);
		
	}


	@Override
	public LlamadaPendiente findByUsuSolAndLlpEstatus(String usuSol, String estatus) throws Exception {
		LlamadaPendiente llamTmp = null;
		try {
			List<LlamadaPendiente> lstLlam = llamdaPendienteDAO.findByUsuSolAndLlpEstatusOrderByLlpIdDesc(usuSol, estatus);
			llamTmp = lstLlam != null && lstLlam.size() > 0 ? lstLlam.get(0) : new LlamadaPendiente();
		} catch (Exception e) {
			logger.error("Error al buscar llamada pendiente");
			throw new Exception(e);
		}
		// TODO Auto-generated method stub
		return llamTmp;
	}


	@Override
	public List<LlamadaPendiente> getFirstLlamadaPendienteByEstatus(String estatis) throws Exception {
		 List<LlamadaPendiente> lstCallTmp = null;
		 try {
			lstCallTmp = llamdaPendienteDAO.findByLlpEstatusOrderByLlpFechaAsc(estatis);
		} catch (Exception e) {
			logger.error("Error al buscar llamadas pendientes by estatus"+ estatis, e);
			throw new Exception(e);
		}
		return lstCallTmp;
	}


	@Override
	public LlamadaPendiente asignaLlamadaMedicoGral() throws Exception {
		LlamadaPendiente llamada = null;
		try {
			List<LlamadaPendiente> lstLla = getFirstLlamadaPendienteByEstatus(Const.ESTATUS_LLAMADA_X_ATENDER);
			if(lstLla != null && lstLla.size() > 0) {
				llamada = lstLla.get(0);
			}
		} catch (Exception e) {
			logger.error("Error al buscar uñtima llamada", e);
			throw new Exception(e);
		}
		// TODO Auto-generated method stub
		return llamada;
	}


	@Override
	public List<LlamadaPendiente> getLlamdaMedico(String userNameMedico) throws Exception {
		 List<LlamadaPendiente> lstCallTmp = new ArrayList<LlamadaPendiente>();
		 try {
			 llamdaPendienteDAO.findByUsuAtiendeOrderByLlpFechaDesc(userNameMedico).forEach(item -> {
				 if(item.getLlpFecha() != null &&  item.getLlpFechaFin() != null)
					 item.setDuracion(Utils.getDiferenciaHora(item.getLlpFecha(), item.getLlpFechaFin()));
				 lstCallTmp.add(item);
				 
			 });
		} catch (Exception e) {
			logger.error("Error al buscar llamadas pendientes by estatus"+ userNameMedico, e);
			throw new Exception(e);
		}
		return lstCallTmp;
	}


	@Override
	public List<LlamadaPendiente> getLlamdaPaciente(String userNameMedico, String estatus) throws Exception {
		 List<LlamadaPendiente> lstCallTmp = new ArrayList<LlamadaPendiente>();
		 try {
			 llamdaPendienteDAO.findByUsuSolAndLlpEstatusOrderByLlpFechaDesc(userNameMedico, estatus).forEach(item -> {
				 item.setDuracion(Utils.getDiferenciaHora(item.getLlpFecha(), item.getLlpFechaFin()));
				 lstCallTmp.add(item);
				 
			 });
		} catch (Exception e) {
			logger.error("Error al buscar llamadas pendientes by estatus"+ userNameMedico, e);
			throw new Exception(e);
		}
		return lstCallTmp;
	}


	@Override
	public LlamadaPendiente findById(Integer llamadaId) throws Exception {
		LlamadaPendiente llamadaPendiente = null;
		 try {
			 llamadaPendiente = llamdaPendienteDAO.findByLlpId(llamadaId.longValue());
		} catch (Exception e) {
			logger.error("Error al buscar llamadas pendientes by estatus"+ llamadaId, e);
			throw new Exception(e);
		}
		return llamadaPendiente;
	}


	@Override
	public MedicoLlamada save(MedicoLlamada medicoLlamada) throws Exception {
		try {
			medicoLlamada = medicoLlamadaDAO.save(medicoLlamada);
		} catch (Exception e) {
			logger.error("Error al buscar llamadas pendientes by estatus"+ medicoLlamada.getUserMedico(), e);
			throw new Exception(e);
		}
		return medicoLlamada;
	}
}
