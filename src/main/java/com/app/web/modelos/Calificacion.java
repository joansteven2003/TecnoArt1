package com.app.web.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Calificacion")
public class Calificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdCalificacion;

	@Column(name = "Estrellas", nullable = true)
	private int Estrellas;

	@OneToOne
	@JoinColumn(name = "venta_id")
	private Venta venta;

	public Calificacion() {
		super();
	}

	public Calificacion(long idCalificacion, int estrellas, Venta venta) {
		IdCalificacion = idCalificacion;
		Estrellas = estrellas;
		this.venta = venta;
	}

	public long getIdCalificacion() {
		return IdCalificacion;
	}

	public void setIdCalificacion(long idCalificacion) {
		IdCalificacion = idCalificacion;
	}

	public int getEstrellas() {
		return Estrellas;
	}

	public void setEstrellas(int estrellas) {
		Estrellas = estrellas;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Calificacion{" +
				"IdCalificacion=" + IdCalificacion +
				", Estrellas=" + Estrellas +
				", venta=" + venta +
				'}';
	}
}
