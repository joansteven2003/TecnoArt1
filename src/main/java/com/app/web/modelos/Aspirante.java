package com.app.web.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Aspirante")
public class Aspirante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idaspirante;

	@Column(name = "numDocumento", nullable = false)
	private Long NumDocumento;

	@Column(name = "TipoDC", nullable = false, length = 10)
	private String TipoDC;

	@Column(name = "Correo", nullable = false, length = 100)
	private String Correo;

	@Column(name = "Nombre", nullable = false, length = 50)
	private String Nombre;

	@Column(name = "Apellido", nullable = false, length = 50)
	private String Apellido;

	@Column(name = "telefono", nullable = false)
	private Long Telefono;

	@Column(name = "Direccion", nullable = false, length = 100)
	private String Direccion;

	@Column(name = "Nacionalidad", nullable = false, length = 30)
	private String Nacionalidad;

	@OneToOne(mappedBy = "documentacion")
	private HojaDeVida hojaDeVida;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Contrato_id", referencedColumnName = "IdContrato")
	private Contrato Contrato;

	@ManyToMany
	@JoinTable(name = "Postulacion", joinColumns = @JoinColumn(name = "idaspirante", referencedColumnName = "idaspirante"), inverseJoinColumns = @JoinColumn(name = "IdVacante", referencedColumnName = "IdVacante"))
	private List<Vacante> Vacante = new ArrayList<>();

	@OneToOne(mappedBy = "aspirante")
	private Cita cita;

	public Aspirante() {
	}

	public Aspirante(Long idaspirante, Long numDocumento, String tipoDC, String correo, String nombre, String apellido, Long telefono, String direccion, String nacionalidad, HojaDeVida hojaDeVida, com.app.web.modelos.Contrato contrato, List<com.app.web.modelos.Vacante> vacante, Cita cita) {
		this.idaspirante = idaspirante;
		NumDocumento = numDocumento;
		TipoDC = tipoDC;
		Correo = correo;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		Direccion = direccion;
		Nacionalidad = nacionalidad;
		this.hojaDeVida = hojaDeVida;
		Contrato = contrato;
		Vacante = vacante;
		this.cita = cita;
	}

	public Long getIdaspirante() {
		return idaspirante;
	}

	public void setIdaspirante(Long idaspirante) {
		this.idaspirante = idaspirante;
	}

	public Long getNumDocumento() {
		return NumDocumento;
	}

	public void setNumDocumento(Long numDocumento) {
		NumDocumento = numDocumento;
	}

	public String getTipoDC() {
		return TipoDC;
	}

	public void setTipoDC(String tipoDC) {
		TipoDC = tipoDC;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Long getTelefono() {
		return Telefono;
	}

	public void setTelefono(Long telefono) {
		Telefono = telefono;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public HojaDeVida getHojaDeVida() {
		return hojaDeVida;
	}

	public void setHojaDeVida(HojaDeVida hojaDeVida) {
		this.hojaDeVida = hojaDeVida;
	}

	public com.app.web.modelos.Contrato getContrato() {
		return Contrato;
	}

	public void setContrato(com.app.web.modelos.Contrato contrato) {
		Contrato = contrato;
	}

	public List<com.app.web.modelos.Vacante> getVacante() {
		return Vacante;
	}

	public void setVacante(List<com.app.web.modelos.Vacante> vacante) {
		Vacante = vacante;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	@Override
	public String toString() {
		return "Aspirante{" +
				"idaspirante=" + idaspirante +
				", NumDocumento=" + NumDocumento +
				", TipoDC='" + TipoDC + '\'' +
				", Correo='" + Correo + '\'' +
				", Nombre='" + Nombre + '\'' +
				", Apellido='" + Apellido + '\'' +
				", Telefono=" + Telefono +
				", Direccion='" + Direccion + '\'' +
				", Nacionalidad='" + Nacionalidad + '\'' +
				", hojaDeVida=" + hojaDeVida +
				", Contrato=" + Contrato +
				", Vacante=" + Vacante +
				", cita=" + cita +
				'}';
	}
}