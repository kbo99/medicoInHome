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

import com.medico.home.admon.pago.dao.ITipoPagoDAO;
import com.medico.home.commons.pago.model.TipoPago;

/**
 * @author rgarciaq
 *
 */
@Service
public class TipoPagoService implements ITipoPago {
	
	@Autowired
	ITipoPagoDAO tipoPagoDAO;
	
	Logger logger = LoggerFactory.getLogger(TipoPagoService.class);

	/*
	 * (non-Javadoc)
	 * @see com.salesforce.pago.service.ITipoPago#save(com.salesforce.pago.vo.TipoPago)
	 */
	@Override
	public TipoPago save(TipoPago tpoPago) throws Exception {
		try {
			tpoPago = tipoPagoDAO.save(tpoPago);
		} catch (Exception e) {
			logger.error("Error al guardar el tipo de pago  \n" + e + "\n" + e.getMessage() + e.getStackTrace());
			throw new Exception(e);
		}
		return tpoPago;
	}

	/*
	 * (non-Javadoc)
	 * @see com.salesforce.pago.service.ITipoPago#findByEstatus(java.lang.String)
	 */
	@Override
	public List<TipoPago> findByEstatus(String estatus) throws Exception{
		List<TipoPago> lstTpoPago = new ArrayList<TipoPago>();
		try {
			lstTpoPago = tipoPagoDAO.findByTppEstatus(estatus);
		} catch (Exception e) {
			logger.error("Error al guardar el tipo de pago  \n" + e + "\n" + e.getMessage() + e.getStackTrace());
			throw new Exception(e);
		}
		return lstTpoPago;
	}

}
