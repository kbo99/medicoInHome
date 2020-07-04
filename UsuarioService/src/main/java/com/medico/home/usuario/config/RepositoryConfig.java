package com.medico.home.usuario.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.medico.home.commons.usuario.menu.model.Menu;
import com.medico.home.commons.usuario.menu.model.SubMenu;
import com.medico.home.commons.usuario.menu.model.SubMenusRel;
import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.Usuario;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

	//@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Usuario.class, Grupo.class, Menu.class, SubMenu.class, SubMenusRel.class);
	}

}
