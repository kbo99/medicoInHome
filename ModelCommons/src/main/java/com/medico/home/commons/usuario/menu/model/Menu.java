package com.medico.home.commons.usuario.menu.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the menus database table.
 * 
 */
@Entity
@Table(name="menus")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable, Comparable<Menu> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="men_id")
	private int menId;

	@Column(name="grp_id")
	private int grpId;

	@Column(name="men_desc")
	private String menDesc;
	
	@Column(name="men_nombre")
	private String menNombre;

	@OneToMany(mappedBy="menu")
	private List<SubMenu> submenus;
	
	@Column(name="men_orden")
	private Integer menOrden;
	
	public Menu() {
	}


	/**
	 * @return the menId
	 */
	public int getMenId() {
		return menId;
	}


	/**
	 * @param menId the menId to set
	 */
	public void setMenId(int menId) {
		this.menId = menId;
	}


	public int getGrpId() {
		return this.grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getMenDesc() {
		return this.menDesc;
	}

	public void setMenDesc(String menDesc) {
		this.menDesc = menDesc;
	}


	/**
	 * @return the menNombre
	 */
	public String getMenNombre() {
		return menNombre;
	}


	/**
	 * @param menNombre the menNombre to set
	 */
	public void setMenNombre(String menNombre) {
		this.menNombre = menNombre;
	}


	/**
	 * @return the submenus
	 */
	public List<SubMenu> getSubmenus() {
		return submenus;
	}


	/**
	 * @param submenus the submenus to set
	 */
	public void setSubmenus(List<SubMenu> submenus) {
		this.submenus = submenus;
	}


	public Integer getMenOrden() {
		return menOrden;
	}


	public void setMenOrden(Integer menOrden) {
		this.menOrden = menOrden;
	}


	@Override
	public int compareTo(Menu o) {
		int order = 0;
		if (o.getMenOrden() != null && this.getMenOrden() != null) 
			order = o.getMenOrden() < this.getMenOrden() ? 1 : -1;
		
		return order;
	}

}