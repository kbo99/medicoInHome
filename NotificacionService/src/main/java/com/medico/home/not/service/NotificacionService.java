/**
 * 
 */
package com.medico.home.not.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.not.dao.INotificaFcmDAO;
import com.medico.home.not.model.NotificacionFcm;

/**
 * @author macpro
 *
 */
@Service
public class NotificacionService implements INotificacionFCM {
	
	@Autowired
	INotificaFcmDAO notificaFcmDAO;

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
	public List<NotificacionFcm> findTknDoctorUrgencia(NotificacionFcm user) {
		List<NotificacionFcm> lstNoti = new ArrayList<NotificacionFcm>();
		lstNoti = notificaFcmDAO.findByNfcDoctorAndNfcEnllamada("V", "F");
		lstNoti.forEach(item -> {
			item.setTitulo(user.getTitulo());
			item.setMensaje(user.getMensaje());
			item.setLatitude(user.getLatitude());
			item.setLongitude(user.getLongitude());
		});
		return lstNoti;
		
	}

	@Override
	public List<String> findTknDoctorAsignado(List<Integer> lstDoc) {
		// TODO Auto-generated method stub
		return null;
	}

}
