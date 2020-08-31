package com.medico.home.oauth.segurity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.oauth.service.admon.IAdmonServiceFeign;
import com.medico.home.oauth.service.usuario.IUsuarioFeign;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private IAdmonServiceFeign admonService;
	
	@Autowired
	private IUsuarioFeign usuarioBean;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Usuario usuario = usuarioBean.findByUsuUsuario(authentication.getName());
		Persona persona = admonService.findPersonaById(usuario.getPerId());
		
		map.put("perId", persona.getPerId());
		map.put("nombre", persona.getPerNombre());
		map.put("apeM", persona.getPerApeMat());
		map.put("apeP", persona.getPerApePate());
		map.put("email", persona.getPerEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
		
		return accessToken;
	}

}
