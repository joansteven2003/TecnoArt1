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


	@Column(name= "correo", nullable = false,length = 150)
	private String correo;

	@Column (name = "Documento", nullable = false)
	private Long Documento;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "hora")
	private Time hora;

	@OneToOne
	@JoinColumn(name = "IdPostulacion")
	private Postulacion postulacion;

	@OneToOne(mappedBy = "cita", cascade = CascadeType.ALL)
	private Resultado resultado;

	public Cita() {
	}

	public Cita(Long idCita, String direccion, String correo, Long documento, String nombre, Date fecha, Time hora, Postulacion postulacion, Resultado resultado) {
		IdCita = idCita;
		this.direccion = direccion;
		this.correo = correo;
		Documento = documento;
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.postulacion = postulacion;
		this.resultado = resultado;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getDocumento() {
		return Documento;
	}

	public void setDocumento(Long documento) {
		Documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Postulacion getPostulacion() {
		return postulacion;
	}

	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Cita{" +
				"IdCita=" + IdCita +
				", direccion='" + direccion + '\'' +
				", correo='" + correo + '\'' +
				", Documento=" + Documento +
				", nombre='" + nombre + '\'' +
				", fecha=" + fecha +
				", hora=" + hora +
				", postulacion=" + postulacion +
				", resultado=" + resultado +
				'}';
	}
}
