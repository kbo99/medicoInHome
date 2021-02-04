/**
 * 
 */
package com.medico.home.usuario.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.UsuGrupo;
import com.medico.home.commons.usuario.model.Usuario;

/**
 * @author macpro
 *
 */
public interface IUsuGrupoDAO extends PagingAndSortingRepository<UsuGrupo, Integer> {
	
	List<UsuGrupo> findByIdUsuId(Integer usuId);
	
	@Query("SELECT gpo FROM Grupo gpo WHERE gpo.grpId in (?1)")
	List<Grupo> getGrupoUser(List<Integer> grpId );
	
	@Query("SELECT user FROM Usuario user WHERE user.usuUsuario = ?1")
	Usuario getUsuUsuario(String usuUsuario);

}
