package com.app.web.modelos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdRol;

	@Column(name = "NombreRol", nullable = true)
	private String NombreRol;

	@OneToMany(mappedBy = "rol",cascade = CascadeType.ALL)
	List<Usuario>listaUsuarios;

	public Rol() {
	}

	public Rol(long idRol, String nombreRol, List<Usuario> listaUsuarios) {
		IdRol = idRol;
		NombreRol = nombreRol;
		this.listaUsuarios = listaUsuarios;
	}

	public long getIdRol() {
		return IdRol;
	}

	public void setIdRol(long idRol) {
		IdRol = idRol;
	}

	public String getNombreRol() {
		return NombreRol;
	}

	public void setNombreRol(String nombreRol) {
		NombreRol = nombreRol;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	@Override
	public String toString() {
		return "Rol{" +
				"IdRol=" + IdRol +
				", NombreRol='" + NombreRol + '\'' +
				", listaUsuarios=" + listaUsuarios +
				'}';
	}
}