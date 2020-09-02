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

import com.medico.home.admon.pago.dao.IFormaPagoDAO;
import com.medico.home.commons.pago.model.FormaPago;

/**
 * @author Ricardo
 *
 */
@Service
public class FormaPagoService implements IFormaPago {
	
	@Autowired
	IFormaPagoDAO formaPagoDAO;
	


	
	Logger logger = LoggerFactory.getLogger(FormaPagoService.class);

	/* (non-Javadoc)
	 * @see com.salesforce.pago.service.IFormaPago#findByEstatus(java.lang.String)
	 */
	@Override
	public List<FormaPago> findByEstatus(String estatus) throws Exception {
		List<FormaPago> lstForma = new ArrayList<FormaPago>();
		try {
			lstForma =formaPagoDAO.findByFpaEstatus(estatus);
		} catch (Exception e) {
			logger.error("Error al buscar forma pago  \n" + e + "\n" + e.getMessage() + e.getStackTrace());
			throw new Exception(e);
		}
		// TODO Auto-generated method stub
		return lstForma;
	}

	/*
	 * (non-Javadoc)
	 * @see com.salesforce.pago.service.IFormaPago#save(com.salesforce.pago.vo.FormaPagoVO)
	 */
	@Override
	public FormaPago save(FormaPago formaPago) throws Exception {
		FormaPago frm = new FormaPago();
		try {
			frm = formaPagoDAO.save(formaPago);
		} catch (Exception e) {
			logger.error("Error al guardar forma de pago ", e);
			throw new Exception(e);
		}
		return frm;
	}

}
