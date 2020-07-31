/**
 * 
 */
package com.medico.home.usuario.parametro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.commons.model.Parametro;
import com.medico.home.usuario.parametro.dao.IParametroDAO;

/**
 * @author macpro
 *
 */
@Service 
public class ParametroService implements IParametroService {
	
	 Logger logger = LoggerFactory.getLogger(ParametroService.class);
	
	@Autowired
	IParametroDAO parametroDAO;

	@Override
	public String findByPrmNombre(String prmNombre) throws Exception{
		Parametro param =  null;
		try {
			param = parametroDAO.findByPrmNombre(prmNombre);
		} catch (Exception e) {
			logger.error("error al buscar lst param", e);
			throw new Exception(e);
		}
		return param != null ? param.getPrmNombre() : null;
	}

	@Override
	public Map<String, String> findByPrmNombre(String... parmLst) throws Exception{
		Map<String, String> mapParam = null;
		try {
			List<String> lstParam = new ArrayList<String>();
			for(String paramName : parmLst) {
				lstParam.add(paramName);
			}
			if(lstParam.size() > 0) {
				List<Parametro> lstTmp = parametroDAO.findByPrmNombreIn(lstParam);
				if(lstTmp != null && lstTmp.size() > 0) {
					 mapParam  = new HashMap<String, String>();
					 for(Parametro param : lstTmp) {
						 mapParam.put(param.getPrmNombre(), param.getPrmValor());
					 }
					
				}
				
				
				
			}
				
			 
		} catch (Exception e) {
			logger.error("error al buscar lst param", e);
			throw new Exception(e);
		}
		return mapParam;
	}

}
