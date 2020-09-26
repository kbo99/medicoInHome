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
import com.medico.home.commons.cliente.model.ClientePersona;
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
					if(res.getContesto() != null && res.getContesto().size() == 1) {
						res.setResValorTmp((res.getContesto().get(0)).getRcuValor());
					}
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
			List<Seccion> lstSecc = cuestionario.getTipoCuest().getSecciones();
			cuestionario = save(cuestionario);
			
			for(Seccion seccion : lstSecc) {
				saveResCues(seccion.getPreguntas(),cuestionario.getCueId());
			}
			
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
		cuestionario = cuestionarioDAO.save(cuestionario);
		return cuestionario;
	}
	
	
	private void saveResCues(List<Pregunta> lstPregunta, Integer cueId)throws Exception {
		try {
			lstPregunta.forEach(pregunt ->{
				pregunt.getRespuestas().forEach(res -> {
					if(res.getResTipoComp() == 1 && (res.getContesto() == null ||
							res.getContesto().size() == 0) && res.getResValorTmp() != null
							&& res.getResValorTmp().length() > 0) {
						ResCuest resc = new ResCuest();
						resc.setRcuValor(res.getResValorTmp());
						resc.setResId(res.getResId());
						res.setContesto(new ArrayList<ResCuest>());
						res.getContesto().add(resc);
					}
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


	@Override
	public Cuestionario findByCueId(Integer cueId) throws Exception {
		Cuestionario cuestTemp= new Cuestionario();
		try {
			cuestTemp = cuestionarioDAO.findByCueId(cueId);
			
			
			//se settean sus secciones
			cuestTemp.getTipoCuest().setSecciones(getListSeccByTpoCues(cuestTemp.getTipoCuest().getTpcId(),
					cuestTemp.getCueId()));
		} catch (Exception e) {
			logg.error("Error al generar nuevo cest", e);
			throw new Exception();
		}
		return cuestTemp;
	}


	@Override
	public Cuestionario findCuestoByUserName(String userName) throws Exception {
		Cuestionario cuestTemp= new Cuestionario();
		try {
			ClientePersona cppe = clienteService.findByPersonaPerTelefono(userName);
			if(cppe != null)
				cuestTemp = getCuestionarioByCpeIdAndTpoCues(cppe.getCpeId(), Const.TIPO_CUES_HISTORIAL);
			
		} catch (Exception e) {
			logg.error("Error al buscar nuevo cest", e);
			throw new Exception();
		}
		return cuestTemp;
	}


	@Override
	public List<Cuestionario> findByClientePersonaCpeId(Integer cpeId) throws Exception {
		 List<Cuestionario> lstCues = new ArrayList<Cuestionario>();
		 try {
			lstCues = cuestionarioDAO.findByClientePersonaCpeIdOrderByCueIdDesc(cpeId);
		} catch (Exception e) {
			logg.error("Error al buscar nuevo cest", e);
			throw new Exception();
		}
		return lstCues;
	}


	@Override
	public List<Cuestionario> findByClientePersonaUser(String cpeId) throws Exception {
		 List<Cuestionario> lstCues = new ArrayList<Cuestionario>();
		 try {
			 ClientePersona clie = clienteService.findByPersonaPerTelefono(cpeId);
			 
			 if(clie != null)
				 lstCues = findByClientePersonaCpeId(clie.getCpeId());
			 
		} catch (Exception e) {
			logg.error("Error al buscar nuevo cest", e);
			throw new Exception();
		}
		return lstCues;
	}
	


}
