/**
 * 
 */
package com.medico.home.oauth.service.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.Usuario;

import feign.FeignException;

/**
 * @author kbo99
 *
 */
@Service
public class UsuarioService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private IUsuarioFeign usuarioBean;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Usuario usuario = usuarioBean.findByUsuUsuario(username);

			List<GrantedAuthority> authorities = usuario.getGrupos().stream()
					.map(grupo -> new SimpleGrantedAuthority(grupo.getGrpNombre()))
					.peek(autority -> logger.info("Role: ".concat(autority.getAuthority())))
					.collect(Collectors.toList());

			return new User(usuario.getUsuUsuario(), usuario.getUsuPassword(), usuario.getUsuEstatus().equals("AC"),
					true, true, true, authorities);

		} catch (FeignException e) {
			logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
		}

	}

}
