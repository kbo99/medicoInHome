/**
 * 
 */
package com.medico.home.commons.util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author macpro
 *
 */
public class Utils {
	
	
	public static String getDiferenciaHora(Date dateIni, Date dateFin) {
		LocalTime startLocalTime = convertToLocalDateTimeViaMilisecond(dateIni).toLocalTime();
		LocalTime endLocalTime = convertToLocalDateTimeViaMilisecond(dateFin).toLocalTime();  // 11:30

		long diffSeconds = Duration.between(startLocalTime, endLocalTime).getSeconds();

		long p1 = (int) (diffSeconds % 60);
		long p2 = (int) (diffSeconds / 60);
		long p3 = p2 % 60;
        p2 = p2 / 60;
        StringBuffer str = new StringBuffer();
        str.append(p2 <=9 ? "0"+p2 : p2);
        str.append(":");
        str.append(p3 <=9? "0"+p3 : p3);
        str.append(":");
        str.append(p1 <=9 ? "0"+p1 : p1);
		return str.toString();
		
	}
	
	public static LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}

	/**
     * Devuele un null si el id envido es 0
     * @param id
     * @return
     */
    public static Integer getNullToZero (Integer id) {
    	return id != null && id > 0 ? id : null;
    }
}
