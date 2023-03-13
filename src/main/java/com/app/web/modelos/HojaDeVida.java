package com.app.web.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

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
	private String FechaNacimiento;

	@Column(name = "EstadoCivil", nullable = false, length = 10)
	private String EstadoCivil;

	@OneToOne
	@JoinColumn(name = "Documentacion")
	private Documentacion documentacion;

	@OneToOne
	@JoinColumn(name = "Aspirante")
	private Aspirante aspirante;

	public HojaDeVida() {
		super();
	}

	public HojaDeVida(Long idHojaDeVida, int experienciaEnmeses, String descripcionMi, String fechaNacimiento,
			String estadoCivil, Documentacion documentacion, Aspirante aspirante) {
		super();
		IdHojaDeVida = idHojaDeVida;
		ExperienciaEnmeses = experienciaEnmeses;
		DescripcionMi = descripcionMi;
		FechaNacimiento = fechaNacimiento;
		EstadoCivil = estadoCivil;
		this.documentacion = documentacion;
		this.aspirante = aspirante;
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

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getEstadoCivil() {
		return EstadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		EstadoCivil = estadoCivil;
	}

	public Documentacion getDocumentacion() {
		return documentacion;
	}

	public void setDocumentacion(Documentacion documentacion) {
		this.documentacion = documentacion;
	}

	public Aspirante getAspirante() {
		return aspirante;
	}

	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}

	@Override
	public String toString() {
		return "HojaDeVida [IdHojaDeVida=" + IdHojaDeVida + ", ExperienciaEnmeses=" + ExperienciaEnmeses
				+ ", DescripcionMi=" + DescripcionMi + ", FechaNacimiento=" + FechaNacimiento + ", EstadoCivil="
				+ EstadoCivil + ", documentacion=" + documentacion + ", aspirante=" + aspirante + "]";
	}

}
