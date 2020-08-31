/**
 * 
 */
package com.medico.home.commons.usuario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author macpro
 *
 */
@Embeddable
public class UsuGrupoEmbededId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 845135864799316038L;
	
	@Column(name="usu_id")
	private Integer usuId;
	
	@Column(name="grp_id")
	private Integer grpId;
		
	public UsuGrupoEmbededId() {
		
	}
	
	public Integer getUsuId() {
		return usuId;
	}
	
	public void setUsuId(Integer usuId) {
		this.usuId = usuId;
	}
	
	public Integer getGrpId() {
		return grpId;
	}
	
	public void setGrpId(Integer grpId) {
		this.grpId = grpId;
	}


	

}
