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
@Table(name = "Estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdEstado;

	@Column(name = "nombre", nullable = true)
	private String nombre;

	@OneToMany(mappedBy = "estado", cascade = { CascadeType.MERGE })
	List<Pqrs> ListPqrs;

	public Estado() {
		super();
	}

	public Estado(long idEstado, String nombre, List<Pqrs> listPqrs) {
		super();
		IdEstado = idEstado;
		this.nombre = nombre;
		ListPqrs = listPqrs;
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

	public List<Pqrs> getListPqrs() {
		return ListPqrs;
	}

	public void setListPqrs(List<Pqrs> listPqrs) {
		ListPqrs = listPqrs;
	}

	@Override
	public String toString() {
		return "Estado [IdEstado=" + IdEstado + ", nombre=" + nombre + ", ListPqrs=" + ListPqrs + "]";
	}

}
