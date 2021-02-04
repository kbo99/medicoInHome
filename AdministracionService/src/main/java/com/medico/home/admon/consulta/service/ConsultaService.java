/**
 * 
 */
package com.medico.home.admon.consulta.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.admon.consulta.dao.IConsultaDAO;
import com.medico.home.commons.consulta.model.Consulta;

/**
 * @author macpro
 *
 */
@Service
public class ConsultaService implements IConsulta {
	
	Logger logger = LoggerFactory.getLogger(ConsultaService.class);
	

	@Autowired
	IConsultaDAO consultaDAO;


	@Override
	public Consulta save(Consulta consulta) throws Exception {
		
		try {
			consulta.setConFregsitro(new Date());
			consulta.setConFechaConsulta(new Date());
			consulta = consultaDAO.save(consulta);
		} catch (Exception e) {
			logger.error("Error ----------",e);
			throw new Exception();
		}
		// TODO Auto-generated method stub
		return consulta;
	}

	@Override
	public List<Consulta> findByUserRegistra(String user) throws Exception {
		List<Consulta> lsttmp = new ArrayList<Consulta>();
	try {
			lsttmp = consultaDAO.findByUsuRegistra(user);
		} catch (Exception e) {
			logger.error("Error ----------",e);
			throw new Exception();
		}
		// TODO Auto-generated method stub
		return lsttmp;
	}

	@Override
	public List<Consulta> findByTelefonoPac(String telefono) throws Exception {
		List<Consulta> lsttmp = new ArrayList<Consulta>();
	try {
		lsttmp = consultaDAO.findByClientePersonaPersonaPerTelefono(telefono);
		} catch (Exception e) {
			logger.error("Error ----------",e);
			throw new Exception();
		}
		return lsttmp;
	}

}
