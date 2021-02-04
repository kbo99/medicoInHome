/**
 * 
 */
package com.medico.home.not.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.medico.home.not.model.NotificacionFcm;

/**
 * @author macpro
 *
 */
@Repository
public interface INotificaFcmDAO extends PagingAndSortingRepository<NotificacionFcm, Long> {
	
	NotificacionFcm findByUsuUsuarioAndNfcDispositivo(String usuario, String disp);
	
	NotificacionFcm save(NotificacionFcm notifica);
	
	List<NotificacionFcm> findByNfcDoctorAndNfcEnllamada(String doctor, String llamada);

}
