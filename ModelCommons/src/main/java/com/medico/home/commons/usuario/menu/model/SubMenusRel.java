package com.medico.home.commons.usuario.menu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sub_menus_rel database table.
 * 
 */
@Entity
@Table(name="sub_menus_rel")
@NamedQuery(name="SubMenusRel.findAll", query="SELECT s FROM SubMenusRel s")
public class SubMenusRel implements Serializable { 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sre_id") 
	private int sreId;
	
	@Column(name="sme_id_parent")
	private int smeIdParent;
	
	@ManyToOne
	@JoinColumn(name="sme_id_child")
	private SubMenu subMenu;;
	
	public SubMenusRel() {
	}

	public int getSmeIdParent() {
		return this.smeIdParent;
	}

	public void setSmeIdParent(int smeIdParent) {
		this.smeIdParent = smeIdParent;
	}

	/**
	 * @return the sreId
	 */
	public int getSreId() {
		return sreId;
	}

	/**
	 * @param sreId the sreId to set
	 */
	public void setSreId(int sreId) {
		this.sreId = sreId;
	}

	/**
	 * @return the subMenu
	 */
	public SubMenu getSubMenu() {
		return subMenu;
	}

	/**
	 * @param subMenu the subMenu to set
	 */
	public void setSubMenu(SubMenu subMenu) {
		this.subMenu = subMenu;
	}

}