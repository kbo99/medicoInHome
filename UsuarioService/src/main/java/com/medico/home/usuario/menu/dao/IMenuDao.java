package com.medico.home.usuario.menu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.usuario.menu.model.Menu;

@RepositoryRestResource(path = "menu")
public interface IMenuDao extends PagingAndSortingRepository<Menu, Integer>{

	@Query("SELECT m from Menu m where m.grpId in (Select g.grpId from Grupo g where g.grpNombre in (?1))")
	public List<Menu> findMenuByGroup (List<String> grupos);
}
