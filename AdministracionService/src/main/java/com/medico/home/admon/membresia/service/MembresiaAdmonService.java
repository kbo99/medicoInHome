/**
 * 
 */
package com.medico.home.admon.membresia.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.admon.membresia.dao.IBeneficioDAO;
import com.medico.home.commons.beneficio.model.Beneficio;
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

	

}
