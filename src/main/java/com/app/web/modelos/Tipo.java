package com.app.web.modelos;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdTipo;

	@Column(name = "NombreTipo", nullable = true)
	private String NombreTipo;

	@OneToMany(mappedBy = "tipo")
	private Set<Pqrs> pqrs;


	public Tipo() {
		super();
	}

	public Tipo(long idTipo, String nombreTipo, Set<Pqrs> pqrs) {
		IdTipo = idTipo;
		NombreTipo = nombreTipo;
		this.pqrs = pqrs;
	}

	public long getIdTipo() {
		return IdTipo;
	}

	public void setIdTipo(long idTipo) {
		IdTipo = idTipo;
	}

	public String getNombreTipo() {
		return NombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		NombreTipo = nombreTipo;
	}

	public Set<Pqrs> getPqrs() {
		return pqrs;
	}

	public void setPqrs(Set<Pqrs> pqrs) {
		this.pqrs = pqrs;
	}

	@Override
	public String toString() {
		return "Tipo{" +
				"IdTipo=" + IdTipo +
				", NombreTipo='" + NombreTipo + '\'' +
				", pqrs=" + pqrs +
				'}';
	}
}
