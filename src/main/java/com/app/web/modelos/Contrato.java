package com.app.web.modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdContrato;

	@Column(name = "NombreContrato", nullable = false, length = 20)
	private String NombreContrato;


	@Column(name = "Fecha_inicio", nullable = false)
	private Date Fecha_inicio;

	@Column(name = "Fecha_final", nullable = false)
 	private Date Fecha_final;

	@OneToOne
	@JoinColumn(name = "IdUsuario")
	private Usuario usuario;

	public Contrato() {
	}

	public Contrato(Long idContrato, String nombreContrato, Date fecha_inicio, Date fecha_final, Usuario usuario) {
		IdContrato = idContrato;
		NombreContrato = nombreContrato;
		Fecha_inicio = fecha_inicio;
		Fecha_final = fecha_final;
		this.usuario = usuario;


	}

	public Long getIdContrato() {
		return IdContrato;
	}

	public void setIdContrato(Long idContrato) {
		IdContrato = idContrato;
	}

	public String getNombreContrato() {
		return NombreContrato;
	}

	public void setNombreContrato(String nombreContrato) {
		NombreContrato = nombreContrato;
	}

	public Date getFecha_inicio() {
		return Fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		Fecha_inicio = fecha_inicio;
	}

	public Date getFecha_final() {
		return Fecha_final;
	}

	public void setFecha_final(Date fecha_final) {
		Fecha_final = fecha_final;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Contrato{" +
				"IdContrato=" + IdContrato +
				", NombreContrato='" + NombreContrato + '\'' +
				", Fecha_inicio=" + Fecha_inicio +
				", Fecha_final=" + Fecha_final +
				", usuario=" + usuario +
				'}';
	}
}

