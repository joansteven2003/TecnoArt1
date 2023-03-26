package com.app.web.modelos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdTipo;

	@Column(name = "NombreTipo", nullable = true)
	private String NombreTipo;

	@OneToMany(mappedBy = "tipo", cascade = { CascadeType.MERGE })
	List<Pqrs> ListPqrs;

	public Tipo() {
		super();
	}

	public Tipo(long idTipo, String nombreTipo, List<Pqrs> listPqrs) {
		IdTipo = idTipo;
		NombreTipo = nombreTipo;
		ListPqrs = listPqrs;
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

	public List<Pqrs> getListPqrs() {
		return ListPqrs;
	}

	public void setListPqrs(List<Pqrs> listPqrs) {
		ListPqrs = listPqrs;
	}

	
	

	
	
}
