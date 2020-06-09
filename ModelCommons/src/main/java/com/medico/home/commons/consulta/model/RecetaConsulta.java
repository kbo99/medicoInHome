package com.medico.home.commons.consulta.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the receta_consulta database table.
 * 
 */
@Entity
@Table(name="receta_consulta")
@NamedQuery(name="RecetaConsulta.findAll", query="SELECT r FROM RecetaConsulta r")
public class RecetaConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rcc_id")
	private int rccId;

	@Column(name="rcc_observciones_gral")
	private String rccObservcionesGral;

	@Column(name="rcc_surte_farmacia")
	private String rccSurteFarmacia;

	@Temporal(TemporalType.DATE)
	@Column(name="rcc_vigencia")
	private Date rccVigencia;

	//bi-directional many-to-one association to DetalleRecetaConsulta
	@OneToMany(mappedBy="recetaConsulta")
	private List<DetalleRecetaConsulta> detalleRecetaConsultas;

	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="con_id")
	private Consulta consulta;

	public RecetaConsulta() {
	}

	public int getRccId() {
		return this.rccId;
	}

	public void setRccId(int rccId) {
		this.rccId = rccId;
	}

	public String getRccObservcionesGral() {
		return this.rccObservcionesGral;
	}

	public void setRccObservcionesGral(String rccObservcionesGral) {
		this.rccObservcionesGral = rccObservcionesGral;
	}

	public String getRccSurteFarmacia() {
		return this.rccSurteFarmacia;
	}

	public void setRccSurteFarmacia(String rccSurteFarmacia) {
		this.rccSurteFarmacia = rccSurteFarmacia;
	}

	public Date getRccVigencia() {
		return this.rccVigencia;
	}

	public void setRccVigencia(Date rccVigencia) {
		this.rccVigencia = rccVigencia;
	}

	public List<DetalleRecetaConsulta> getDetalleRecetaConsultas() {
		return this.detalleRecetaConsultas;
	}

	public void setDetalleRecetaConsultas(List<DetalleRecetaConsulta> detalleRecetaConsultas) {
		this.detalleRecetaConsultas = detalleRecetaConsultas;
	}

	public DetalleRecetaConsulta addDetalleRecetaConsulta(DetalleRecetaConsulta detalleRecetaConsulta) {
		getDetalleRecetaConsultas().add(detalleRecetaConsulta);
		detalleRecetaConsulta.setRecetaConsulta(this);

		return detalleRecetaConsulta;
	}

	public DetalleRecetaConsulta removeDetalleRecetaConsulta(DetalleRecetaConsulta detalleRecetaConsulta) {
		getDetalleRecetaConsultas().remove(detalleRecetaConsulta);
		detalleRecetaConsulta.setRecetaConsulta(null);

		return detalleRecetaConsulta;
	}

	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}