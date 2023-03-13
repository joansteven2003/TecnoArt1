package com.app.web.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdVenta;

	@Column(name = "Fecha_venta", nullable = false, length = 20, unique = true)
	private String Fecha_venta;

	@Column(name = "Fecha_entrega", nullable = false, length = 20, unique = true)
	private String Fecha_entrega;

	@Column(name = "Monto", nullable = false, length = 50)
	private double Monto;

	@Column(name = "Estado", nullable = false, length = 50)
	private String Estado;

	@Column(name = "Observacion", nullable = false, length = 50)
	private String Observacion;

	@OneToMany(mappedBy = "venta", cascade = { CascadeType.MERGE })
	List<Pqrs> ListPqrs;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	public Venta() {
		super();
	}

	public Venta(Long idVenta, String fecha_venta, String fecha_entrega, double monto, String estado,
			String observacion, List<Pqrs> listPqrs, Usuario usuario) {
		super();
		IdVenta = idVenta;
		Fecha_venta = fecha_venta;
		Fecha_entrega = fecha_entrega;
		Monto = monto;
		Estado = estado;
		Observacion = observacion;
		ListPqrs = listPqrs;
		this.usuario = usuario;
	}

	public Long getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(Long idVenta) {
		IdVenta = idVenta;
	}

	public String getFecha_venta() {
		return Fecha_venta;
	}

	public void setFecha_venta(String fecha_venta) {
		Fecha_venta = fecha_venta;
	}

	public String getFecha_entrega() {
		return Fecha_entrega;
	}

	public void setFecha_entrega(String fecha_entrega) {
		Fecha_entrega = fecha_entrega;
	}

	public double getMonto() {
		return Monto;
	}

	public void setMonto(double monto) {
		Monto = monto;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

	public List<Pqrs> getListPqrs() {
		return ListPqrs;
	}

	public void setListPqrs(List<Pqrs> listPqrs) {
		ListPqrs = listPqrs;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Venta [IdVenta=" + IdVenta + ", Fecha_venta=" + Fecha_venta + ", Fecha_entrega=" + Fecha_entrega
				+ ", Monto=" + Monto + ", Estado=" + Estado + ", Observacion=" + Observacion + ", ListPqrs=" + ListPqrs
				+ ", usuario=" + usuario + "]";
	}

}
