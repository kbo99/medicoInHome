/**
 * 
 */
package com.medico.home.sender.service;

import com.medico.home.sender.vo.NotificacionVO;

/**
 * @author macpro
 *
 */
public interface ISenderService {
	
	static final String TIWILIO_USER_MESSAGE = "TIWILO_MS_USR";
	
	static final String TIWILIO_TKN_MESSAGE = "TIWILO_TK_USR";
	
	static final String TIWILIO_NM_MESSAGE = "TIWILO_NM_MESS";
	
	static final String USER_NM_MESSAGE = "USER_NM_MESSAGE";
	
	void sendMessageContingengia(NotificacionVO notificacion);
	
	void sendMessageContingengia();

}
