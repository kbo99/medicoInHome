/**
 * 
 */
package com.medico.home.not.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.commons.util.Const;
import com.medico.home.not.dao.ILlamadaPendienteDAO;
import com.medico.home.not.model.LlamadaPendiente;

/**
 * @author macpro
 *
 */
@Service
public class LlamadaPendienteService implements ILlamadaPendiente {
	
	
	Logger logger = LoggerFactory.getLogger(LlamadaPendienteService.class);
	
	@Autowired
	ILlamadaPendienteDAO llamdaPendienteDAO;

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
			llamTmp = llamdaPendienteDAO.findByUsuSolAndLlpEstatus(usuSol, estatus);
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
}
