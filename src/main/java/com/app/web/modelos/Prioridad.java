package com.app.web.modelos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prioridad")
public class Prioridad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdPrioridad;

	@Column(name = "NombrePrioridad", nullable = true)
	private String NombrePrioridad;

	@OneToMany(mappedBy = "prioridad", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pqrs> pqrs = new HashSet<>();

	public Prioridad() {
		super();
	}

	public Prioridad(long idPrioridad, String nombrePrioridad, Set<Pqrs> pqrs) {
		IdPrioridad = idPrioridad;
		NombrePrioridad = nombrePrioridad;
		this.pqrs = pqrs;
	}

	public long getIdPrioridad() {
		return IdPrioridad;
	}

	public void setIdPrioridad(long idPrioridad) {
		IdPrioridad = idPrioridad;
	}

	public String getNombrePrioridad() {
		return NombrePrioridad;
	}

	public void setNombrePrioridad(String nombrePrioridad) {
		NombrePrioridad = nombrePrioridad;
	}

	public Set<Pqrs> getPqrs() {
		return pqrs;
	}

	public void setPqrs(Set<Pqrs> pqrs) {
		this.pqrs = pqrs;
	}

	@Override
	public String toString() {
		return "Prioridad{" +
				"IdPrioridad=" + IdPrioridad +
				", NombrePrioridad='" + NombrePrioridad + '\'' +
				", pqrs=" + pqrs +
				'}';
	}
}
