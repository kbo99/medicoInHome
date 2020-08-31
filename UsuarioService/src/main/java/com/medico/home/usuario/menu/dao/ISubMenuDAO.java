/**
 * 
 */
package com.medico.home.usuario.menu.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medico.home.commons.usuario.menu.model.SubMenu;

/**
 * @author kbo99
 *
 */
@RepositoryRestResource(path = "submenu")
public interface ISubMenuDAO  extends PagingAndSortingRepository<SubMenu, Integer> {

}
