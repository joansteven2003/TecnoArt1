package com.app.web.modelos;

import java.util.List;

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

	@OneToMany(mappedBy = "prioridad", cascade = { CascadeType.MERGE })
	List<Pqrs> ListPqrs;

	public Prioridad() {
		super();
	}

	public Prioridad(long idPrioridad, String nombrePrioridad, List<Pqrs> listPqrs) {
		super();
		IdPrioridad = idPrioridad;
		NombrePrioridad = nombrePrioridad;
		ListPqrs = listPqrs;
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

	public List<Pqrs> getListPqrs() {
		return ListPqrs;
	}

	public void setListPqrs(List<Pqrs> listPqrs) {
		ListPqrs = listPqrs;
	}

	@Override
	public String toString() {
		return "Prioridad [IdPrioridad=" + IdPrioridad + ", NombrePrioridad=" + NombrePrioridad + ", ListPqrs="
				+ ListPqrs + "]";
	}

}
