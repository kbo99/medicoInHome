/**
 * 
 */
package com.medico.home.admon.pago.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.admon.pago.dao.IPagoEstatusDAO;
import com.medico.home.commons.pago.model.PagoEstatus;

/**
 * @author Ricardo
 *
 */
@Service
public class PagoEstatusService implements IPagoEstatus {
	
	@Autowired
	IPagoEstatusDAO pagoEstatsDAO;

	
	Logger logger = LoggerFactory.getLogger(PagoEstatusService.class);
	
	/* (non-Javadoc)
	 * @see com.salesforce.pago.service.IPagoEstatus#findByEstatus(java.lang.String)
	 */
	@Override
	public List<PagoEstatus> findByEstatus(String estatus) throws Exception {
		List<PagoEstatus> lsyPagoEst = new ArrayList<PagoEstatus>();
		try {
			pagoEstatsDAO.findByPgsEstatus(estatus);

		} catch (Exception e) {
			logger.error("Error al buscar forma de pago  \n" + e + "\n" + e.getMessage() + e.getStackTrace());
			throw new Exception(e);
		}
		return lsyPagoEst;
	}

	/*
	 * (non-Javadoc)
	 * @see com.salesforce.pago.service.IPagoEstatus#save(com.salesforce.pago.vo.PagoEstatus)
	 */
	@Override
	public PagoEstatus save(PagoEstatus pagoEstatus) throws Exception {
		PagoEstatus pgEstTmp = new PagoEstatus();
		try {
			pgEstTmp = pagoEstatsDAO.save(pagoEstatus);
		} catch (Exception e) {
			logger.error("Error al guardar  estatus pago" , e);
			throw new Exception(e);
		}
		return pgEstTmp;
	}

}
