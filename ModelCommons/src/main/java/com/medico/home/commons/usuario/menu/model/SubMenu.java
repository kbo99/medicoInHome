package com.medico.home.commons.usuario.menu.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: SubMenu
 *
 */
@Entity
@Table(name="sub_menus")
@NamedQuery(name="SubMenu.findAll", query="SELECT m FROM SubMenu m")
public class SubMenu implements Serializable, Comparable<SubMenu> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sme_id")
	private Integer smeId;
	
	@Column(name="sme_nombre")
	private String smeNombre;
	
	@Column(name="sme_desc")
	private String smedesc;
	
	@Column(name="sme_icono")
	private String smeIcono;
	
	@Column(name="sme_url")
	private String smeURL;
	
	//bi-directional many-to-one association to Colonia
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="men_id")
	private Menu menu;
	
	@Column(name="sme_orden")
	private Integer smeOrden;
	
	@Transient
	private List<SubMenu> subMenus;
	
	public SubMenu() {
	}

	/**
	 * @return the smeId
	 */
	public Integer getSmeId() {
		return smeId;
	}

	/**
	 * @param smeId the smeId to set
	 */
	public void setSmeId(Integer smeId) {
		this.smeId = smeId;
	}

	/**
	 * @return the smeNombre
	 */
	public String getSmeNombre() {
		return smeNombre;
	}

	/**
	 * @param smeNombre the smeNombre to set
	 */
	public void setSmeNombre(String smeNombre) {
		this.smeNombre = smeNombre;
	}

	/**
	 * @return the smedesc
	 */
	public String getSmedesc() {
		return smedesc;
	}

	/**
	 * @param smedesc the smedesc to set
	 */
	public void setSmedesc(String smedesc) {
		this.smedesc = smedesc;
	}

	/**
	 * @return the smeIcono
	 */
	public String getSmeIcono() {
		return smeIcono;
	}

	/**
	 * @param smeIcono the smeIcono to set
	 */
	public void setSmeIcono(String smeIcono) {
		this.smeIcono = smeIcono;
	}

	/**
	 * @return the smeURL
	 */
	public String getSmeURL() {
		return smeURL;
	}

	/**
	 * @param smeURL the smeURL to set
	 */
	public void setSmeURL(String smeURL) {
		this.smeURL = smeURL;
	}

	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getSmeOrden() {
		return smeOrden;
	}

	public void setSmeOrden(Integer smeOrden) {
		this.smeOrden = smeOrden;
	}


	public List<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	@Override
	public int compareTo(SubMenu o) {
		int order = 0;
		if (o.getSmeOrden() != null && this.getSmeOrden() != null) 
			order = o.getSmeOrden() < this.getSmeOrden() ? 1 : -1;
		
		return order;
	}
   
}
