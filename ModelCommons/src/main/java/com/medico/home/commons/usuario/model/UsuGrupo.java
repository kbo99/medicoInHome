/**
 * 
 */
package com.medico.home.commons.usuario.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author macpro
 *
 */
@Entity
public class UsuGrupo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1832532405028464255L;
	
	@EmbeddedId
	private UsuGrupoEmbededId id;
	
	public UsuGrupo() {
		
	}

	public UsuGrupoEmbededId getId() {
		return id;
	}

	public void setId(UsuGrupoEmbededId id) {
		this.id = id;
	}
	
	
	

}
