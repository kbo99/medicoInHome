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

import com.medico.home.admon.membresia.dao.IBeneficioDAO;
import com.medico.home.admon.membresia.dao.IMembresiaDAO;
import com.medico.home.commons.beneficio.model.Beneficio;
import com.medico.home.commons.membresia.model.Membresia;
import com.medico.home.commons.membresia.model.MembresiaBeneficio;
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
	public Membresia nueva(final Membresia membresia) throws Exception {
		Membresia membresiaTmp = new Membresia();
		try {
			membresia.setMemEstatus(Const.ESTATUS_ACTIVO);
			membresia.setMemFcreacion(new Date());
			List<MembresiaBeneficio> lstTmp = new ArrayList<MembresiaBeneficio>();
			membresia.getBeneficios().forEach(item-> {
				MembresiaBeneficio tmp = new MembresiaBeneficio();
				tmp.setBeneficio(item);
				tmp.setMembresia(membresia);
				lstTmp.add(tmp);
			});
			membresiaTmp = membresia;
			membresiaTmp.setMembresiaBeneficios(lstTmp);
			membresiaTmp = save(membresiaTmp);
		} catch (Exception e) {
			logger.error("Error al guardar memebresia", e);
			throw new Exception(e);
		}
		return membresiaTmp;
	}

	

}
