package com.medico.home.usuario.menu.service;

import java.util.List;

import com.medico.home.commons.usuario.menu.model.Menu;
import com.medico.home.commons.usuario.model.Grupo;

public interface ImenuService {

	/**
	 * Busca menu dependiendo los grupos del usuario
	 * @param grupos
	 * @return
	 */
	public List<Menu> getMenyByGroup(List<Grupo> grupos);
}
