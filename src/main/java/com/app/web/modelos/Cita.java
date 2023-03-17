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

}
