/**
 * 
 */
package com.medico.home.admon.persona.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.doctor.model.Doctor;

/**
 * @author macpro
 *
 */
public interface IDoctorDAO extends PagingAndSortingRepository<Doctor, Integer> {

}
