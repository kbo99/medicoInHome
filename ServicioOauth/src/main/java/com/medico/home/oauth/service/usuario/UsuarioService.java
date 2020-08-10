/**
 * 
 */
package com.medico.home.oauth.service.usuario;

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

import com.medico.home.commons.usuario.model.Usuario;

import brave.Tracer;
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
	
	@Autowired
	private Tracer tracer;
	
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
			String mns = "Error en el Login: no existe el usuario '" + username + "' en el sistema!";
			logger.error(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			logger.error(mns);
			
			tracer.currentSpan().tag("error login", mns + ": " + e.getMessage());
			
			throw new UsernameNotFoundException(mns);
		}

	}

}
