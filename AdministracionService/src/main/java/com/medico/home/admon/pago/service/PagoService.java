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

import com.medico.home.admon.pago.dao.IPagoDAO;
import com.medico.home.commons.pago.model.Pago;

/**
 * @author rgarciaq
 *
 */
@Service
public class PagoService implements IPago {
	
	
	@Autowired
	IPagoDAO pagoDAO;
	
	

	
	Logger logger = LoggerFactory.getLogger(PagoService.class);
	
	/*
	 * (non-Javadoc)
	 * @see com.salesforce.pago.service.IPago#save(com.salesforce.pago.vo.Pago)
	 */
	@Override
	public Pago save(Pago pago) throws Exception {
		Pago Pago = new Pago();
		try {
			Pago = pagoDAO.save(pago);
		} catch (Exception e) {
			logger.error("Error al guardar el pago  \n" + e + "\n" + e.getMessage() + e.getStackTrace());
			throw new Exception(e);
		}
		return Pago;
	}






	/*
	 * (non-Javadoc)
	 * @see com.salesforce.pago.service.IPago#findByPagoEstatus(java.lang.Integer)
	 */
	@Override
	public List<Pago> findByPagoEstatus(Integer pgsId) throws Exception {
		List<Pago> lstPago = new ArrayList<Pago>();
		try {
			lstPago =	pagoDAO.findByPagoEstatusPgsId(pgsId);

		} catch (Exception e) {
			logger.error("Error al consultar pagos por estatus \n" + e);
			throw new Exception(e);
		}
		return lstPago;
	}
	
	

}
