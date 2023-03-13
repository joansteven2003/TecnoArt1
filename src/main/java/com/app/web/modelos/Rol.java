package com.app.web.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdRol;

	@Column(name = "NombreRol", nullable = true)
	private String NombreRol;

	public Rol() {
		super();
	}

	public Rol(long idRol, String nombreRol) {
		super();
		IdRol = idRol;
		NombreRol = nombreRol;
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

	@Override
	public String toString() {
		return "Rol [IdRol=" + IdRol + ", NombreRol=" + NombreRol + "]";
	}

}
