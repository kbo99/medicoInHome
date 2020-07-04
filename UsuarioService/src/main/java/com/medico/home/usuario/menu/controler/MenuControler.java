/**
 * 
 */
package com.medico.home.usuario.menu.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.commons.usuario.menu.model.Menu;
import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.usuario.menu.service.ImenuService;

/**
 * @author kbo99
 *
 */
@RestController
@RequestMapping("/grupo/menu")
public class MenuControler {

	@Autowired
	private ImenuService menuService;
	
	@PostMapping("/getmenu")
	public List<Menu> findMenus(@RequestBody List<Grupo> grupos) {
		return menuService.getMenyByGroup(grupos);
	}
}
