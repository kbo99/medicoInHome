package com.medico.home.commons.producto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductoPK id;

	@Column(name="cps_id")
	private int cpsId;

	@Column(name="prod_clave")
	private String prodClave;

	@Column(name="prod_costo_compra")
	private BigDecimal prodCostoCompra;

	@Column(name="prod_costo_venta")
	private BigDecimal prodCostoVenta;

	@Column(name="prod_desc")
	private BigDecimal prodDesc;

	@Column(name="prod_descrip")
	private String prodDescrip;

	@Column(name="prod_estatus")
	private String prodEstatus;

	@Column(name="prod_existencia_min")
	private int prodExistenciaMin;

	@Column(name="prod_proveedor")
	private String prodProveedor;

	//bi-directional many-to-one association to TipoProducto
	@ManyToOne
	@JoinColumn(name="tpoprod_id")
	private TipoProducto tipoProducto;

	public Producto() {
	}

	public ProductoPK getId() {
		return this.id;
	}

	public void setId(ProductoPK id) {
		this.id = id;
	}

	public int getCpsId() {
		return this.cpsId;
	}

	public void setCpsId(int cpsId) {
		this.cpsId = cpsId;
	}

	public String getProdClave() {
		return this.prodClave;
	}

	public void setProdClave(String prodClave) {
		this.prodClave = prodClave;
	}

	public BigDecimal getProdCostoCompra() {
		return this.prodCostoCompra;
	}

	public void setProdCostoCompra(BigDecimal prodCostoCompra) {
		this.prodCostoCompra = prodCostoCompra;
	}

	public BigDecimal getProdCostoVenta() {
		return this.prodCostoVenta;
	}

	public void setProdCostoVenta(BigDecimal prodCostoVenta) {
		this.prodCostoVenta = prodCostoVenta;
	}

	public BigDecimal getProdDesc() {
		return this.prodDesc;
	}

	public void setProdDesc(BigDecimal prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdDescrip() {
		return this.prodDescrip;
	}

	public void setProdDescrip(String prodDescrip) {
		this.prodDescrip = prodDescrip;
	}

	public String getProdEstatus() {
		return this.prodEstatus;
	}

	public void setProdEstatus(String prodEstatus) {
		this.prodEstatus = prodEstatus;
	}

	public int getProdExistenciaMin() {
		return this.prodExistenciaMin;
	}

	public void setProdExistenciaMin(int prodExistenciaMin) {
		this.prodExistenciaMin = prodExistenciaMin;
	}

	public String getProdProveedor() {
		return this.prodProveedor;
	}

	public void setProdProveedor(String prodProveedor) {
		this.prodProveedor = prodProveedor;
	}

	public TipoProducto getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

}