package com.medico.home.commons.servicio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tipo_servicio database table.
 * 
 */
@Entity
@Table(name="tipo_servicio")
@NamedQuery(name="TipoServicio.findAll", query="SELECT t FROM TipoServicio t")
public class TipoServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tps_id")
	private int tpsId;

	@Column(name="tps_codigo")
	private String tpsCodigo;

	@Column(name="tps_desc")
	private String tpsDesc;

	@Column(name="tps_estatus")
	private String tpsEstatus;

	@Temporal(TemporalType.DATE)
	@Column(name="tps_fecha")
	private Date tpsFecha;

	@Column(name="tps_nombre")
	private String tpsNombre;

	@Column(name="tps_opera_ambos")
	private String tpsOperaAmbos;

	@Column(name="tps_solo_prov")
	private String tpsSoloProv;

	@Column(name="usu_registra")
	private String usuRegistra;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="tipoServicio")
	private List<Servicio> servicios;

	public TipoServicio() {
	}

	public int getTpsId() {
		return this.tpsId;
	}

	public void setTpsId(int tpsId) {
		this.tpsId = tpsId;
	}

	public String getTpsCodigo() {
		return this.tpsCodigo;
	}

	public void setTpsCodigo(String tpsCodigo) {
		this.tpsCodigo = tpsCodigo;
	}

	public String getTpsDesc() {
		return this.tpsDesc;
	}

	public void setTpsDesc(String tpsDesc) {
		this.tpsDesc = tpsDesc;
	}

	public String getTpsEstatus() {
		return this.tpsEstatus;
	}

	public void setTpsEstatus(String tpsEstatus) {
		this.tpsEstatus = tpsEstatus;
	}

	public Date getTpsFecha() {
		return this.tpsFecha;
	}

	public void setTpsFecha(Date tpsFecha) {
		this.tpsFecha = tpsFecha;
	}

	public String getTpsNombre() {
		return this.tpsNombre;
	}

	public void setTpsNombre(String tpsNombre) {
		this.tpsNombre = tpsNombre;
	}

	public String getTpsOperaAmbos() {
		return this.tpsOperaAmbos;
	}

	public void setTpsOperaAmbos(String tpsOperaAmbos) {
		this.tpsOperaAmbos = tpsOperaAmbos;
	}

	public String getTpsSoloProv() {
		return this.tpsSoloProv;
	}

	public void setTpsSoloProv(String tpsSoloProv) {
		this.tpsSoloProv = tpsSoloProv;
	}

	public String getUsuRegistra() {
		return this.usuRegistra;
	}

	public void setUsuRegistra(String usuRegistra) {
		this.usuRegistra = usuRegistra;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setTipoServicio(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setTipoServicio(null);

		return servicio;
	}

}