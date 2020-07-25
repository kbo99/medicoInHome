/**
 * 
 */
package com.medico.home.not.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.not.dao.IParametroDAO;
import com.medico.home.not.model.Parametro;

/**
 * @author macpro
 *
 */
@Service
public class ParametroNotify implements IParametroNotify {
	
	@Autowired
	IParametroDAO parametroDAO;

	@Override
	public String getParamValorById(String prnId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getMapByParams(String... params) {
		List<String> lstParms = new ArrayList<String>();
		for(String prnId : params) {
			lstParms.add(prnId);
		}
		Map<String, String> mapParams = null;
		if(lstParms.size() > 0) {
			List<Parametro> lstParamTmp = parametroDAO.findByPrnIdIn(lstParms);
			if(lstParamTmp != null && lstParamTmp.size() > 0) {
				mapParams = new HashMap<String, String>();
				for(Parametro item : lstParamTmp) {
					mapParams.put(item.getPrnId(), item.getPrnValor());
				}
			}
			
		}
		
		
		return mapParams;
	}

}
