package com.medico.home.commons.cotizacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cotizacion_estatus database table.
 * 
 */
@Entity
@Table(name="cotizacion_estatus")
@NamedQuery(name="CotizacionEstatus.findAll", query="SELECT c FROM CotizacionEstatus c")
public class CotizacionEstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ctesta_id")
	private int ctestaId;

	@Column(name="ctesta_descrp")
	private String ctestaDescrp;

	@Column(name="ctesta_nombre")
	private String ctestaNombre;

	//bi-directional many-to-one association to Cotizacion
	@OneToMany(mappedBy="cotizacionEstatus")
	private List<Cotizacion> cotizacions;

	public CotizacionEstatus() {
	}

	public int getCtestaId() {
		return this.ctestaId;
	}

	public void setCtestaId(int ctestaId) {
		this.ctestaId = ctestaId;
	}

	public String getCtestaDescrp() {
		return this.ctestaDescrp;
	}

	public void setCtestaDescrp(String ctestaDescrp) {
		this.ctestaDescrp = ctestaDescrp;
	}

	public String getCtestaNombre() {
		return this.ctestaNombre;
	}

	public void setCtestaNombre(String ctestaNombre) {
		this.ctestaNombre = ctestaNombre;
	}

	public List<Cotizacion> getCotizacions() {
		return this.cotizacions;
	}

	public void setCotizacions(List<Cotizacion> cotizacions) {
		this.cotizacions = cotizacions;
	}

	public Cotizacion addCotizacion(Cotizacion cotizacion) {
		getCotizacions().add(cotizacion);
		cotizacion.setCotizacionEstatus(this);

		return cotizacion;
	}

	public Cotizacion removeCotizacion(Cotizacion cotizacion) {
		getCotizacions().remove(cotizacion);
		cotizacion.setCotizacionEstatus(null);

		return cotizacion;
	}

}