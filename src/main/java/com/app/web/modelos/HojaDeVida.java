package com.app.web.modelos;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "HojaDeVida")
@Data
public class HojaDeVida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdHojaDeVida;

	@Column(name = "ExperienciaEnmeses", nullable = false)
	private int ExperienciaEnmeses;

	@Column(name = "DescripcionMi", nullable = false)
	private String DescripcionMi;

	@Column(name = "FechaNacimiento", nullable = false)
	private Date FechaNacimiento;

	@Column(name = "EstadoCivil", nullable = false, length = 10)
	private String EstadoCivil;

	@OneToOne
	@JoinColumn(name = "Usuario")
	private Usuario usuario;


	public HojaDeVida() {
		super();
	}

	public HojaDeVida(Long idHojaDeVida, int experienciaEnmeses, String descripcionMi, Date fechaNacimiento, String estadoCivil, Usuario usuario) {
		IdHojaDeVida = idHojaDeVida;
		ExperienciaEnmeses = experienciaEnmeses;
		DescripcionMi = descripcionMi;
		FechaNacimiento = fechaNacimiento;
		EstadoCivil = estadoCivil;
		this.usuario = usuario;
	}

	public Long getIdHojaDeVida() {
		return IdHojaDeVida;
	}

	public void setIdHojaDeVida(Long idHojaDeVida) {
		IdHojaDeVida = idHojaDeVida;
	}

	public int getExperienciaEnmeses() {
		return ExperienciaEnmeses;
	}

	public void setExperienciaEnmeses(int experienciaEnmeses) {
		ExperienciaEnmeses = experienciaEnmeses;
	}

	public String getDescripcionMi() {
		return DescripcionMi;
	}

	public void setDescripcionMi(String descripcionMi) {
		DescripcionMi = descripcionMi;
	}

	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getEstadoCivil() {
		return EstadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		EstadoCivil = estadoCivil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "HojaDeVida{" +
				"IdHojaDeVida=" + IdHojaDeVida +
				", ExperienciaEnmeses=" + ExperienciaEnmeses +
				", DescripcionMi='" + DescripcionMi + '\'' +
				", FechaNacimiento=" + FechaNacimiento +
				", EstadoCivil='" + EstadoCivil + '\'' +
				", usuario=" + usuario +
				'}';
	}
}
