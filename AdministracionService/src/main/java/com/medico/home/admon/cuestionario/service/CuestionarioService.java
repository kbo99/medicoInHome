/**
 * 
 */
package com.medico.home.admon.cuestionario.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.admon.cliente.service.IClienteService;
import com.medico.home.admon.cuestionario.dao.ICuestionarioDAO;
import com.medico.home.admon.cuestionario.dao.IResCuestDAO;
import com.medico.home.admon.cuestionario.dao.IResHijaDAO;
import com.medico.home.admon.cuestionario.dao.ITipoCuesDAO;
import com.medico.home.admon.cuestionario.dao.ITipoSeccDAO;
import com.medico.home.commons.cuestionario.model.Cuestionario;
import com.medico.home.commons.cuestionario.model.Pregunta;
import com.medico.home.commons.cuestionario.model.ResCuest;
import com.medico.home.commons.cuestionario.model.Seccion;
import com.medico.home.commons.util.Const;

/**
 * @author macpro
 *
 */
@Service
public class CuestionarioService implements ICuestionario {
	
	Logger logg = LoggerFactory.getLogger(CuestionarioService.class);
	
	@Autowired
	ITipoSeccDAO tipoSeccDAO;
	
	@Autowired
	ICuestionarioDAO cuestionarioDAO;
	
	@Autowired
	ITipoCuesDAO tipoCuesDAO;
	
	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IResCuestDAO resCuestDAO;
	
	@Autowired
	IResHijaDAO resHijaDAO;

	@Override
	public List<Seccion> getListSeccByTpoCues(Integer tpoCues, Integer cueId) throws Exception {
		List<Seccion> lstSecci = new ArrayList<Seccion>();
		try {
			lstSecci = getListSeccByTpoCues(tpoCues);
			
			lstSecci.forEach(seccion -> {
				seccion.setPreguntas(preguntaChild(seccion.getPreguntas(), cueId));
			});
			
		} catch (Exception e) {
		logg.error("Error al construir cest", e);
		throw new Exception();
		}
		return lstSecci;
	}
	
	
	private List<Pregunta> preguntaChild(List<Pregunta> lstPreg, Integer cueId){
		
		lstPreg.forEach(pregunt ->{
			pregunt.getRespuestas().forEach(res -> {
				if(cueId > 0) {
					res.setContesto(resCuestDAO.findByResIdAndCueId(res.getResId(), cueId));
					
					res.setResSelec(res.getContesto() != null && res.getContesto().size() > 0 ? true : false);
				}
				res.setPregunta(preguntaChild(resHijaDAO.getPreguntaByResPade(res.getResId()),cueId));
				res.setResHabilitaChild(res.getPregunta() != null && res.getPregunta().size() > 0 && res.getResSelec() != null && res.getResSelec());
			});
		});
		return lstPreg;
		
	}

	@Override
	public Cuestionario getCuestionarioByCpeIdAndTpoCues(Integer cpeId, Integer tpoCu) throws Exception {
		Cuestionario cuestTemp;
		try {
			cuestTemp = cuestionarioDAO.findByTipoCuestTpcIdAndClientePersonaCpeIdAndCueEstatus(tpoCu, cpeId,
					Const.ESTATUS_ACTIVO);
			//Si no tiene cuestionario generamos uno
			if(cuestTemp == null) {
				cuestTemp = new Cuestionario();
				//Se consulta el tipo de cuestionario
				cuestTemp.setTipoCuest(tipoCuesDAO.findByTpcId(tpoCu));
				cuestTemp.setCueId(Const.INTEGER_CERO_ID);
				cuestTemp.setClientePersona(clienteService.findByCpeId(cpeId));
			}
			
			//se settean sus secciones
			cuestTemp.getTipoCuest().setSecciones(getListSeccByTpoCues(tpoCu, cuestTemp.getCueId()));
			
		} catch (Exception e) {
		logg.error("Error al construir cest", e);
		throw new Exception();
		}
		return cuestTemp;
	}
	

	@Override
	public List<Seccion> getListSeccByTpoCues(Integer tpoCues) throws Exception {
		List<Seccion> lstSecci = new ArrayList<Seccion>();
		try {
			lstSecci = tipoSeccDAO.getLstSeccByTpoCue(tpoCues);
			
		} catch (Exception e) {
		logg.error("Error al construir cest", e);
		throw new Exception();
		}
		return lstSecci;
	}


	@Override
	public Cuestionario generaNuevo(Cuestionario cuestionario) throws Exception {
		try {
			if(cuestionario.getCueId() != null && cuestionario.getCueId() > 0) {
				cuestionario.setCueEstatus(Const.ESTATUS_OLD);
				save(cuestionario);
				
			}
			cuestionario.setCueId(Const.INTEGER_CERO_ID);
			cuestionario.setCueEstatus(Const.ESTATUS_ACTIVO);
			cuestionario.setCueFecha(new Date());
			save(cuestionario);
			
			cuestionario.getTipoCuest().getSecciones().forEach(item-> {
				try {
					saveResCues(item.getPreguntas(),cuestionario.getCueId());
				} catch (Exception e) {
					logg.error("Error al generar nueva pregunta cest", e);
					cuestionario.setCueEstatus(Const.ESTATUS_ERR);
				} finally {
					if(cuestionario.getCueEstatus().equals(Const.ESTATUS_ERR))
						save(cuestionario);
				}
			});
			cuestionario.getTipoCuest().setSecciones(getListSeccByTpoCues(cuestionario.getTipoCuest().getTpcId(),
					cuestionario.getCueId()));
			
		} catch (Exception e) {
			logg.error("Error al generar nuevo cest", e);
			throw new Exception();
		}
		return cuestionario;
	}


	@Override
	public Cuestionario save(Cuestionario cuestionario)  {
		cuestionarioDAO.save(cuestionario);
		return cuestionario;
	}
	
	
	private void saveResCues(List<Pregunta> lstPregunta, Integer cueId)throws Exception {
		try {
			lstPregunta.forEach(pregunt ->{
				pregunt.getRespuestas().forEach(res -> {
					res.getContesto().forEach(cont-> {
						cont.setRcuId(Const.INTEGER_CERO_ID);
						cont.setCueId(cueId);
						resCuestDAO.save(cont);
					});
					try {
						saveResCues(res.getPregunta(),cueId);
					} catch (Exception e) {
						logg.error("Error al generar nuevo cest", e);
					}
				});
			});
		} catch (Exception e) {
			logg.error("Error al generar nuevo cest", e);
			throw new Exception();
		}
		
	}
	


}
