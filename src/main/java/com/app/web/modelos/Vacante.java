package com.app.web.modelos;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

@Entity
@Table(name = "Vacante")
public class Vacante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdVacante;

	@Column(name = "HoraInicio", nullable = false)
	private Time HoraInicio;

	@Column(name = "HoraFin", nullable = false)
	private Time HoraFin;

	@Column(name = "Perfil", nullable = false, length = 50)
	private String Perfil;

	@Column(name = "LugarTrabajo", nullable = false, length = 20)
	private String LugarTrabajo;

	@Column(name = "Descripcion", nullable = false, length = 1000)
	private String Descripcion;

	@Column(name = "Salario", nullable = false)
	private Long Salario;

	@Column(name = "Eduacion", nullable = false, length = 50)
	private String Eduacion;

	@OneToOne
	@JoinColumn(name = "Cargo")
	private Cargo cargo;

	@OneToOne(mappedBy = "vacante", cascade = CascadeType.ALL)
	private Postulacion postulacion;

	public Vacante(Long idVacante, Time horaInicio, Time horaFin, String perfil, String lugarTrabajo, String descripcion, Long salario, String eduacion, Cargo cargo, Postulacion postulacion) {
		IdVacante = idVacante;
		HoraInicio = horaInicio;
		HoraFin = horaFin;
		Perfil = perfil;
		LugarTrabajo = lugarTrabajo;
		Descripcion = descripcion;
		Salario = salario;
		Eduacion = eduacion;
		this.cargo = cargo;
		this.postulacion = postulacion;
	}

	public Vacante() {
	}

	public Long getIdVacante() {
		return IdVacante;
	}

	public void setIdVacante(Long idVacante) {
		IdVacante = idVacante;
	}

	public Time getHoraInicio() {
		return HoraInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		HoraInicio = horaInicio;
	}

	public Time getHoraFin() {
		return HoraFin;
	}

	public void setHoraFin(Time horaFin) {
		HoraFin = horaFin;
	}

	public String getPerfil() {
		return Perfil;
	}

	public void setPerfil(String perfil) {
		Perfil = perfil;
	}

	public String getLugarTrabajo() {
		return LugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		LugarTrabajo = lugarTrabajo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Long getSalario() {
		return Salario;
	}

	public void setSalario(Long salario) {
		Salario = salario;
	}

	public String getEduacion() {
		return Eduacion;
	}

	public void setEduacion(String eduacion) {
		Eduacion = eduacion;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Postulacion getPostulacion() {
		return postulacion;
	}

	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}

	@Override
	public String toString() {
		return "Vacante{" +
				"IdVacante=" + IdVacante +
				", HoraInicio=" + HoraInicio +
				", HoraFin=" + HoraFin +
				", Perfil='" + Perfil + '\'' +
				", LugarTrabajo='" + LugarTrabajo + '\'' +
				", Descripcion='" + Descripcion + '\'' +
				", Salario=" + Salario +
				", Eduacion='" + Eduacion + '\'' +
				", cargo=" + cargo +
				", postulacion=" + postulacion +
				'}';
	}
}