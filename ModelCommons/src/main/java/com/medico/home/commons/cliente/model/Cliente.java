package com.medico.home.commons.cliente.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_id")
	private int cliId;

	@Column(name="cli_email")
	private String cliEmail;

	@Column(name="cli_estatus")
	private String cliEstatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cli_fregistro")
	private Date cliFregistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cli_fultima_op")
	private Date cliFultimaOp;

	@Column(name="cli_nom_corto")
	private String cliNomCorto;

	@Column(name="cli_obs")
	private String cliObs;

	@Column(name="cli_rfc")
	private String cliRfc;

	@Column(name="cli_web_fac")
	private String cliWebFac;

	@Column(name="usu_registra")
	private String usuRegistra;

	//bi-directional many-to-one association to TipoPersonaClie
	@ManyToOne
	@JoinColumn(name="tpc_id")
	private TipoPersonaClie tipoPersonaClie;


	public Cliente() {
	}

	public int getCliId() {
		return this.cliId;
	}

	public void setCliId(int cliId) {
		this.cliId = cliId;
	}

	public String getCliEmail() {
		return this.cliEmail;
	}

	public void setCliEmail(String cliEmail) {
		this.cliEmail = cliEmail;
	}

	public String getCliEstatus() {
		return this.cliEstatus;
	}

	public void setCliEstatus(String cliEstatus) {
		this.cliEstatus = cliEstatus;
	}

	public Date getCliFregistro() {
		return this.cliFregistro;
	}

	public void setCliFregistro(Date cliFregistro) {
		this.cliFregistro = cliFregistro;
	}

	public Date getCliFultimaOp() {
		return this.cliFultimaOp;
	}

	public void setCliFultimaOp(Date cliFultimaOp) {
		this.cliFultimaOp = cliFultimaOp;
	}

	public String getCliNomCorto() {
		return this.cliNomCorto;
	}

	public void setCliNomCorto(String cliNomCorto) {
		this.cliNomCorto = cliNomCorto;
	}

	public String getCliObs() {
		return this.cliObs;
	}

	public void setCliObs(String cliObs) {
		this.cliObs = cliObs;
	}

	public String getCliRfc() {
		return this.cliRfc;
	}

	public void setCliRfc(String cliRfc) {
		this.cliRfc = cliRfc;
	}

	public String getCliWebFac() {
		return this.cliWebFac;
	}

	public void setCliWebFac(String cliWebFac) {
		this.cliWebFac = cliWebFac;
	}

	public String getUsuRegistra() {
		return this.usuRegistra;
	}

	public void setUsuRegistra(String usuRegistra) {
		this.usuRegistra = usuRegistra;
	}

	public TipoPersonaClie getTipoPersonaClie() {
		return this.tipoPersonaClie;
	}

	public void setTipoPersonaClie(TipoPersonaClie tipoPersonaClie) {
		this.tipoPersonaClie = tipoPersonaClie;
	}





}