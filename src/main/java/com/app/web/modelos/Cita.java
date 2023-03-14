package com.app.web.modelos;

import java.sql.Date;
import java.sql.Time;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cita")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdCita;

	@Column(name = "direccion", nullable = false, length = 50)
	private String direccion;

	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "hora")
	private Time hora;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
	private Usuario usuario;

	public Cita() {
		super();
	}

	public Cita(Long idCita, String direccion, Date fecha, Time hora, Usuario usuario) {
		IdCita = idCita;
		this.direccion = direccion;
		this.fecha = fecha;
		this.hora = hora;
		this.usuario = usuario;
	}

	public Long getIdCita() {
		return IdCita;
	}

	public void setIdCita(Long idCita) {
		IdCita = idCita;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cita{" +
				"IdCita=" + IdCita +
				", direccion='" + direccion + '\'' +
				", fecha=" + fecha +
				", hora=" + hora +
				", usuario=" + usuario +
				'}';
	}
}
