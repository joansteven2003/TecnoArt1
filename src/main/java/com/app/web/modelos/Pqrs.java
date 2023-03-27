package com.app.web.modelos;

import javax.persistence.*;

@Entity
@Table(name = "pqrs")
public class Pqrs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdPqrs;

	@Column(name = "Descripcion", nullable = true)
	private String Descripcion;

	@Column(name = "Fecha", nullable = true)
	private String Fecha;

	@ManyToOne
	@JoinColumn(name = "tipo_id", nullable = false)
	private Tipo tipo;


	@ManyToOne
	@JoinColumn(name = "prioridad_id", nullable = false)
	private Prioridad prioridad;
	@ManyToOne
	@JoinColumn(name = "estado_id", nullable = false)
	private Estado estado;

	@OneToOne(mappedBy = "pqrs")
	private Venta venta;

	@Column(name = "RespuestaPqrs", nullable = true)
	private String RespuestaPqrs;

	public Pqrs() {
		super();
	}

	public Pqrs(long idPqrs, String descripcion, String fecha, Tipo tipo, Prioridad prioridad, Estado estado, Venta venta, String respuestaPqrs) {
		IdPqrs = idPqrs;
		Descripcion = descripcion;
		Fecha = fecha;
		this.tipo = tipo;
		this.prioridad = prioridad;
		this.estado = estado;
		this.venta = venta;
		RespuestaPqrs = respuestaPqrs;
	}

	public long getIdPqrs() {
		return IdPqrs;
	}

	public void setIdPqrs(long idPqrs) {
		IdPqrs = idPqrs;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public String getRespuestaPqrs() {
		return RespuestaPqrs;
	}

	public void setRespuestaPqrs(String respuestaPqrs) {
		RespuestaPqrs = respuestaPqrs;
	}

	@Override
	public String toString() {
		return "Pqrs{" +
				"IdPqrs=" + IdPqrs +
				", Descripcion='" + Descripcion + '\'' +
				", Fecha='" + Fecha + '\'' +
				", tipo=" + tipo +
				", prioridad=" + prioridad +
				", estado=" + estado +
				", venta=" + venta +
				", RespuestaPqrs='" + RespuestaPqrs + '\'' +
				'}';
	}
}
