package com.medico.home.admon.persona.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.medico.home.commons.doctor.model.Doctor;

public interface IDoctorDAO extends PagingAndSortingRepository<Doctor, Integer>{

	

}
