package com.medico.home.commons.direccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the region_pais database table.
 * 
 */
@Entity
@Table(name="region_pais")
@NamedQuery(name="RegionPai.findAll", query="SELECT r FROM RegionPai r")
public class RegionPai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rep_id")
	private int repId;

	@Column(name="rep_desc")
	private String repDesc;

	@Column(name="rep_nombre")
	private String repNombre;

	//bi-directional many-to-one association to Pai
	@OneToMany(mappedBy="regionPai")
	private List<Pai> pais;

	public RegionPai() {
	}

	public int getRepId() {
		return this.repId;
	}

	public void setRepId(int repId) {
		this.repId = repId;
	}

	public String getRepDesc() {
		return this.repDesc;
	}

	public void setRepDesc(String repDesc) {
		this.repDesc = repDesc;
	}

	public String getRepNombre() {
		return this.repNombre;
	}

	public void setRepNombre(String repNombre) {
		this.repNombre = repNombre;
	}

	public List<Pai> getPais() {
		return this.pais;
	}

	public void setPais(List<Pai> pais) {
		this.pais = pais;
	}

	public Pai addPai(Pai pai) {
		getPais().add(pai);
		pai.setRegionPai(this);

		return pai;
	}

	public Pai removePai(Pai pai) {
		getPais().remove(pai);
		pai.setRegionPai(null);

		return pai;
	}

}