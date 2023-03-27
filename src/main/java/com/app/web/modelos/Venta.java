package com.app.web.modelos;

import java.util.List;

import javax.persistence.*;
import com.app.web.modelos.Pqrs;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pqrs_id")
	private Pqrs pqrs;

	@OneToOne(mappedBy = "venta")
	private Calificacion calificacion;

	@OneToMany(mappedBy = "venta")
	private List<Cotizacion> cotizaciones;


	public Venta() {
		super();
	}

	public Venta(Long idVenta, String fecha_venta, String fecha_entrega, double monto, String estado, String observacion, Pqrs pqrs, Calificacion calificacion, List<Cotizacion> cotizaciones) {
		IdVenta = idVenta;
		Fecha_venta = fecha_venta;
		Fecha_entrega = fecha_entrega;
		Monto = monto;
		Estado = estado;
		Observacion = observacion;
		this.pqrs = pqrs;
		this.calificacion = calificacion;
		this.cotizaciones = cotizaciones;
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

	public Pqrs getPqrs() {
		return pqrs;
	}

	public void setPqrs(Pqrs pqrs) {
		this.pqrs = pqrs;
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public List<Cotizacion> getCotizaciones() {
		return cotizaciones;
	}

	public void setCotizaciones(List<Cotizacion> cotizaciones) {
		this.cotizaciones = cotizaciones;
	}

	@Override
	public String toString() {
		return "Venta{" +
				"IdVenta=" + IdVenta +
				", Fecha_venta='" + Fecha_venta + '\'' +
				", Fecha_entrega='" + Fecha_entrega + '\'' +
				", Monto=" + Monto +
				", Estado='" + Estado + '\'' +
				", Observacion='" + Observacion + '\'' +
				", pqrs=" + pqrs +
				", calificacion=" + calificacion +
				", cotizaciones=" + cotizaciones +
				'}';
	}
}
