/**
 * 
 */
package com.medico.home.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medico.home.commons.persona.model.Persona;
import com.medico.home.commons.usuario.model.Grupo;
import com.medico.home.commons.usuario.model.Usuario;
import com.medico.home.commons.util.IconAlert;
import com.medico.home.commons.util.Response;
import com.medico.home.usuario.grupo.service.IGrupoService;
import com.medico.home.usuario.service.IUsuario;

/**
 * @author macpro
 *
 */
@RestController
public class UsuarioController {
	
	
	
	@Autowired
	IUsuario usuarioService;
	
	@Autowired
	IGrupoService grupoService;
	
	@PostMapping("/generaUsuario")
	public Persona generaNuevoUsuario(@RequestBody  Usuario usuario) throws Exception {
		try {
			usuarioService.generateNuevo(usuario); 
		} catch (Exception e) {
			throw new Exception();
		}
		return null;
	}
	
	@GetMapping("/grupo/findAllGpr")
	public ResponseEntity<Response> findAllGrupos()throws Exception {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(grupoService.findAllGrupos());
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch(Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Buscar Grupos");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/grupo/save")
	public ResponseEntity<Response> saveOrUpdateGrupo(@RequestBody Grupo grupo)throws Exception {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			grupoService.saveOrUpdateGrupo(grupo);
			response.setResponse(true);
			response.setMessage("El Grupo  " + grupo.getGrpDesc() + " se guardo correctamente");
			response.setTitle("Grupo Guardado");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch(Exception e) {
			
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al guardar Grupo");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@PostMapping("/role/save")
	public ResponseEntity<Response> getUserGrupo(@RequestBody Usuario usuario)throws Exception {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			grupoService.saveOrUpdateRoles(usuario);
			response.setResponse(true);
			response.setMessage("Roles Actualizados Correctamente");
			response.setTitle("Roles de usuario guardados");
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch(Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al Actualizar Roles de usuario");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@GetMapping("/usuario/findbyusu")
	public ResponseEntity<Response> findByUsuario(@RequestParam String usuUsuario)throws Exception {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(grupoService.findUsuarioByUsuario(usuUsuario));
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch(Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al consultar Usuarios por usuario");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@GetMapping("/usuario/findbynombre")
	public ResponseEntity<Response> findByNombre(@RequestParam String perNombre)throws Exception {
		HttpStatus estatus = HttpStatus.OK;
		Response response = new Response();
		try {
			response.setResponse(grupoService.findUsuarioByPerNombre(perNombre));
			response.setTypeMessage(IconAlert.SUCCESS);
		} catch(Exception e) {
			estatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setTypeMessage(IconAlert.ERROR);
			response.setMsError("Error al consultar usuarios por nombre");
			response.setTitle("Error");
		}
		return new ResponseEntity<Response>(response, estatus);
	}
	
	@GetMapping("/usuario/findbyusuarioin")
	public Usuario findByNombreByUsuario(@RequestParam String usuUsuario)throws Exception {
		return	usuarioService.findByUsuUsuario(usuUsuario);
	}
}
