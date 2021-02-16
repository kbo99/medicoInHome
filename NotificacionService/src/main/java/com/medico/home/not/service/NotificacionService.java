/**
 * 
 */
package com.medico.home.not.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.not.dao.IMedicoLlamadaDAO;
import com.medico.home.not.dao.INotificaFcmDAO;
import com.medico.home.not.model.MedicoLlamada;
import com.medico.home.not.model.NotificacionFcm;

/**
 * @author macpro
 *
 */
@Service
public class NotificacionService implements INotificacionFCM {
	
	@Autowired
	INotificaFcmDAO notificaFcmDAO;
	
	@Autowired
	IMedicoLlamadaDAO medicoLlmadaDAO;

	@Override
	public NotificacionFcm actualizaToken(NotificacionFcm notifica) {
		try {
			NotificacionFcm notificacionTmp = notificaFcmDAO.
					findByUsuUsuarioAndNfcDispositivo(notifica.getUsuUsuario(), 
					notifica.getNfcDispositivo());
			if(notificacionTmp != null && notificacionTmp.getNfcId() > 0) {
				notificacionTmp.setNfcTknFcm(notifica.getNfcTknFcm());
				notificaFcmDAO.save(notificacionTmp);
			} else {
				notificaFcmDAO.save(notifica);
			}
		}catch (Exception e) {
			e.getMessage();
		}
		
		 
		
		
		return notifica;
	}

	@Override
	public List<NotificacionFcm> findTknDoctorUrgencia(NotificacionFcm user,
			String tpoAtiende, String enLlamada) {
		List<NotificacionFcm> lstNoti = new ArrayList<NotificacionFcm>();
		lstNoti = notificaFcmDAO.findByNfcDoctorAndNfcEnllamada(tpoAtiende, enLlamada);
		lstNoti.forEach(item -> {
			buildNotificaDeatil(item, user);
		});
		return lstNoti;
		
	}

	@Override
	public List<String> findTknDoctorAsignado(List<Integer> lstDoc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificacionFcm generaNotificaLlamada(NotificacionFcm user) {
		NotificacionFcm item = notificaFcmDAO.findByUsuUsuario(user.getUsuUsuario());
		buildNotificaDeatil(item, user);
		return item;
	}
	
	
	private NotificacionFcm buildNotificaDeatil(NotificacionFcm item, NotificacionFcm user) {
		item.setTitulo(user.getTitulo());
		item.setMensaje(user.getMensaje());
		item.setLatitude(user.getLatitude() == null ? "" : user.getLatitude());
		item.setLongitude(user.getLongitude() == null ? "" : user.getLongitude());
		item.setCanal(user.getCanal() == null ? "" : user.getCanal());
		item.setTknAgora(user.getTknAgora() == null ? "" : user.getTknAgora());
		item.setIdLlamada(user.getIdLlamada() == null ? 0 : user.getIdLlamada());
		return item;
	}

	@Override
	public MedicoLlamada guardaDetalleLlamada(MedicoLlamada medico) {
		medico.setMllId(0);
		medico = medicoLlmadaDAO.save(medico);
		return medico;
	}
	
	

}
