package com.app.web.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Documentacion")
public class Documentacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdDucumentacion;
	@Column(name = "Certificados", nullable = false, length = 100)
	private String Certificados;
	@Column(name = "DocumenCentification", nullable = false, length = 100)
	private String DocumenCentification;

	@OneToOne(mappedBy = "documentacion")
	private HojaDeVida hojaDeVida;

	public Documentacion() {
		super();
	}

	public Documentacion(Long idDucumentacion, String certificados, String documenCentification,
			HojaDeVida hojaDeVida) {
		super();
		IdDucumentacion = idDucumentacion;
		Certificados = certificados;
		DocumenCentification = documenCentification;
		this.hojaDeVida = hojaDeVida;
	}

	public Long getIdDucumentacion() {
		return IdDucumentacion;
	}

	public void setIdDucumentacion(Long idDucumentacion) {
		IdDucumentacion = idDucumentacion;
	}

	public String getCertificados() {
		return Certificados;
	}

	public void setCertificados(String certificados) {
		Certificados = certificados;
	}

	public String getDocumenCentification() {
		return DocumenCentification;
	}

	public void setDocumenCentification(String documenCentification) {
		DocumenCentification = documenCentification;
	}

	public HojaDeVida getHojaDeVida() {
		return hojaDeVida;
	}

	public void setHojaDeVida(HojaDeVida hojaDeVida) {
		this.hojaDeVida = hojaDeVida;
	}

	@Override
	public String toString() {
		return "Documentacion [IdDucumentacion=" + IdDucumentacion + ", Certificados=" + Certificados
				+ ", DocumenCentification=" + DocumenCentification + ", hojaDeVida=" + hojaDeVida + "]";
	}

}
