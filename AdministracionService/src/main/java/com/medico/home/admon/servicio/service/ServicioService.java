/**
 * 
 */
package com.medico.home.admon.servicio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.admon.servicio.dao.ITipoServicioDAO;
import com.medico.home.commons.servicio.model.TipoServicio;
import com.medico.home.commons.util.Const;

/**
 * @author macpro
 *
 */
@Service
public class ServicioService implements IServicio {
	
	@Autowired
	ITipoServicioDAO tipoServicioDAO;

	/**
	 * Guarda el tipo de servicio
	 */
	@Override
	public TipoServicio save(TipoServicio tpoService) throws Exception{
		try {
			tpoService.setTpsEstatus(Const.ESTATUS_ACTIVO);
			tpoService.setTpsFecha(new Date());
			tpoService = tipoServicioDAO.save(tpoService);
			
		} catch (Exception e) {
			 throw new Exception(e);
		}
		return tpoService;
	}

	@Override
	public List<TipoServicio> findByTpsEstatus(String estatus) {
		return tipoServicioDAO.findByTpsEstatus(estatus);
	}

	@Override
	public TipoServicio update(TipoServicio tpoService) throws Exception {
		try {
			tpoService = tipoServicioDAO.save(tpoService);
			
		} catch (Exception e) {
			 throw new Exception(e);
		}
		return tpoService;
	}

}
