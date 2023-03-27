package com.app.web.modelos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdEstado;

	@Column(name = "nombre", nullable = true)
	private String nombre;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pqrs> pqrs = new HashSet<>();

	public Estado() {
		super();
	}

	public Estado(long idEstado, String nombre, Set<Pqrs> pqrs) {
		IdEstado = idEstado;
		this.nombre = nombre;
		this.pqrs = pqrs;
	}

	public long getIdEstado() {
		return IdEstado;
	}

	public void setIdEstado(long idEstado) {
		IdEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Pqrs> getPqrs() {
		return pqrs;
	}

	public void setPqrs(Set<Pqrs> pqrs) {
		this.pqrs = pqrs;
	}

	@Override
	public String toString() {
		return "Estado{" +
				"IdEstado=" + IdEstado +
				", nombre='" + nombre + '\'' +
				", pqrs=" + pqrs +
				'}';
	}
}
