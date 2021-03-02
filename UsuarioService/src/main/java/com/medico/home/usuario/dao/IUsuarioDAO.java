/**
 * 
 */
package com.medico.home.usuario.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.medico.home.commons.usuario.model.Usuario;

/**
 * @author kbo99
 *
 */
@RepositoryRestResource(path = "usuarios")
public interface IUsuarioDAO extends PagingAndSortingRepository<Usuario, Integer>{

	@RestResource(path = "busca-usuario")
	public Usuario findByUsuUsuario (@RequestParam(name = "usuUsuario") String usuUsuario);
	
	public Usuario findByPerId(Integer perId);
	
	public List<Usuario> findByUsuUsuarioContains( String usuUsuario);
}
