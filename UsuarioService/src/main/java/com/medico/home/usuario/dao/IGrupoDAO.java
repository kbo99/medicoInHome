package com.medico.home.usuario.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.usuario.model.Grupo;

public interface IGrupoDAO extends PagingAndSortingRepository<Grupo, Integer>{

	
	List<Grupo> findBygrpEstatus (String grpEstatus);
}
