/**
 * 
 */
package com.medico.home.not.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.not.model.Token;

/**
 * @author macpro
 *
 */
public interface ITokenDAO extends PagingAndSortingRepository<Token, String> {
	


	List<Token> findByUsuarioIn(List<String> lstDoctores);
	
	Token findByUsuario(String usuario);
	
	
}
