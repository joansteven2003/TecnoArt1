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
	@JoinColumn(name = "IdCargo")
	private Cargo cargo;

	@ManyToMany(mappedBy = "Vacante")
	private List<Aspirante> aspirante = new ArrayList<>();

	public Vacante() {
		super();
	}

	public Vacante(Long idVacante, Time horaInicio, Time horaFin, String perfil, String lugarTrabajo,
			String descripcion, Long salario, String eduacion, Cargo cargo, List<Aspirante> aspirante) {
		super();
		IdVacante = idVacante;
		HoraInicio = horaInicio;
		HoraFin = horaFin;
		Perfil = perfil;
		LugarTrabajo = lugarTrabajo;
		Descripcion = descripcion;
		Salario = salario;
		Eduacion = eduacion;
		this.cargo = cargo;
		this.aspirante = aspirante;
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

	public List<Aspirante> getAspirante() {
		return aspirante;
	}

	public void setAspirante(List<Aspirante> aspirante) {
		this.aspirante = aspirante;
	}

	@Override
	public String toString() {
		return "Vacante [IdVacante=" + IdVacante + ", HoraInicio=" + HoraInicio + ", HoraFin=" + HoraFin + ", Perfil="
				+ Perfil + ", LugarTrabajo=" + LugarTrabajo + ", Descripcion=" + Descripcion + ", Salario=" + Salario
				+ ", Eduacion=" + Eduacion + ", cargo=" + cargo + ", aspirante=" + aspirante + "]";
	}

}