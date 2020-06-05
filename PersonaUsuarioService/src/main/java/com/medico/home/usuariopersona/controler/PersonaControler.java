/**
 * 
 */
package com.medico.home.usuariopersona.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.usuariopersona.app.services.IPersonaService;
import com.medico.home.commons.persona.model.Persona;


/**
 * @author kbo99
 *
 */
@RefreshScope
@RestController
public class PersonaControler {

	private static Logger log = LoggerFactory.getLogger(PersonaControler.class); 
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/listar")
	public List<Persona> listar(){
		System.out.println(port);
		return personaService.findAllPersonas();
	}

	@GetMapping("/ver/{id}")
	public Persona detalle(@PathVariable Integer id) {
		return personaService.findPersonaByIs(id);
	}
	
	@GetMapping("/prueba")
	public ResponseEntity<?> obtConfid(@Value("${server.port}") String puerto) {
		log.info(puerto);
				
		Map<String, String> json = new HashMap<String, String>();
		json.put("puerto", puerto);
		json.put("configuracion.name", env.getProperty("configuracion.name"));
		if (env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
			json.put("configuracion.autor.nombre", env.getProperty("configuracion.autor.nombre"));
		}
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
}
