package com.app.web.modelos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "servicio")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdServicio;

	@Column(name = "Nombre_servicio", nullable = false, length = 20, unique = true)
	private String Nombre_servicio;

	@Column(name = "Valor_venta", nullable = false, length = 10)
	private int Valor_venta;

	@Column(name = "Descripcion", nullable = false, length = 20)
	private String Descripcion;

	@OneToOne(mappedBy = "servicio", cascade = CascadeType.ALL)
	private Venta venta;

	public Servicio() {
		super();
	}

	public Servicio(Long idServicio, String nombre_servicio, int valor_venta, String descripcion, Venta venta) {
		IdServicio = idServicio;
		Nombre_servicio = nombre_servicio;
		Valor_venta = valor_venta;
		Descripcion = descripcion;
		this.venta = venta;
	}

	public Long getIdServicio() {
		return IdServicio;
	}

	public void setIdServicio(Long idServicio) {
		IdServicio = idServicio;
	}

	public String getNombre_servicio() {
		return Nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		Nombre_servicio = nombre_servicio;
	}

	public int getValor_venta() {
		return Valor_venta;
	}

	public void setValor_venta(int valor_venta) {
		Valor_venta = valor_venta;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Servicio{" +
				"IdServicio=" + IdServicio +
				", Nombre_servicio='" + Nombre_servicio + '\'' +
				", Valor_venta=" + Valor_venta +
				", Descripcion='" + Descripcion + '\'' +
				", venta=" + venta +
				'}';
	}
}