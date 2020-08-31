package com.medico.home.usuario.menu.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.home.commons.usuario.menu.model.Menu;
import com.medico.home.commons.usuario.menu.model.SubMenu;
import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.usuario.menu.dao.IMenuDao;
import com.medico.home.usuario.menu.dao.ISubMenusRelDAO;

/**
 * 
 * @author kbo99
 *
 */
@Service
public class MenuService implements ImenuService{

	@Autowired
	private IMenuDao menuDao;
	
	@Autowired
	private ISubMenusRelDAO subMenuRelDAO;
	
	@Override
	public List<Menu> getMenyByGroup(List<Grupo> grupos) {
		List<Menu> menu = menuDao.findMenuByGroup(grupos.stream().map(g -> g.getGrpNombre()).collect(Collectors.toList()));
		menu.forEach(m-> { 
			Collections.sort(m.getSubmenus());
			m.getSubmenus().forEach(sub -> sub.setSubMenus(buitSubMenu(sub)));
		});
		Collections.sort(menu);
		
		return menu;
	}

	/**
	 * Construe subMenus
	 * @param subMenu
	 * @return
	 */
	private List<SubMenu> buitSubMenu (SubMenu subMenu) {
		List<SubMenu> buitSubMenus = subMenuRelDAO.findByParent(subMenu.getSmeId());
		buitSubMenus.forEach(sub -> sub.setSubMenus(buitSubMenu(sub)));
		Collections.sort(buitSubMenus);
		return buitSubMenus;
	}
}
