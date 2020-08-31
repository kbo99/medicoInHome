/**
 * 
 */
package com.medico.home.usuario.menu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.medico.home.commons.usuario.menu.model.SubMenu;
import com.medico.home.commons.usuario.menu.model.SubMenusRel;

/**
 * @author kbo99
 *
 */
@RepositoryRestResource(path = "subenurel")
public interface ISubMenusRelDAO extends PagingAndSortingRepository<SubMenusRel, Integer>{

	@RestResource(path = "lista-subrel")
	@Query("Select sub From SubMenusRel sub Where sub.smeIdParent in (?1)")
	public List<SubMenusRel> findBySmeIdParent(@RequestParam List<Integer> ids);
	
	@RestResource(path = "lista-sub")
	@Query("Select sub.subMenu From SubMenusRel sub Where sub.smeIdParent in (?1)")
	public List<SubMenu> findByParent(@RequestParam Integer ids);
}
