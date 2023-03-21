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

	@Column(name = "institucion", nullable = false)
	private String institucion;

	@Column(name = "Titulo", nullable = false)
	private String Titulo;

	@Column(name = "fecha_grado", nullable = false)
	private Date fecha_grado;

	@Column(name = "Empresa", nullable = false)
	private String Empresa;

	@Column(name = "Puesto", nullable = false)
	private String Puesto;

	@Column(name = "fecha_inicio", nullable = false)
	private Date fecha_inicio;

	@Column(name = "fecha_fin", nullable = false)
	private Date fecha_fin;

	@Column(name = "DescripcionT", nullable = false)
	private String DescripcionT;

	@Column(name = "habilidades", nullable = false)
	private String habilidades;

	@Column(name = "referencias", nullable = false)
	private String referencias;

	@OneToOne
	@JoinColumn(name = "Usuario")
	private Usuario usuario;

	public HojaDeVida() {
	}

	public HojaDeVida(Long idHojaDeVida, String institucion, String titulo, Date fecha_grado, String empresa, String puesto, Date fecha_inicio, Date fecha_fin, String descripcionT, String habilidades, String referencias, Usuario usuario) {
		IdHojaDeVida = idHojaDeVida;
		this.institucion = institucion;
		Titulo = titulo;
		this.fecha_grado = fecha_grado;
		Empresa = empresa;
		Puesto = puesto;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		DescripcionT = descripcionT;
		this.habilidades = habilidades;
		this.referencias = referencias;
		this.usuario = usuario;
	}

	public Long getIdHojaDeVida() {
		return IdHojaDeVida;
	}

	public void setIdHojaDeVida(Long idHojaDeVida) {
		IdHojaDeVida = idHojaDeVida;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public Date getFecha_grado() {
		return fecha_grado;
	}

	public void setFecha_grado(Date fecha_grado) {
		this.fecha_grado = fecha_grado;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public String getPuesto() {
		return Puesto;
	}

	public void setPuesto(String puesto) {
		Puesto = puesto;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getDescripcionT() {
		return DescripcionT;
	}

	public void setDescripcionT(String descripcionT) {
		DescripcionT = descripcionT;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
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
				", institucion='" + institucion + '\'' +
				", Titulo='" + Titulo + '\'' +
				", fecha_grado=" + fecha_grado +
				", Empresa='" + Empresa + '\'' +
				", Puesto='" + Puesto + '\'' +
				", fecha_inicio=" + fecha_inicio +
				", fecha_fin=" + fecha_fin +
				", DescripcionT='" + DescripcionT + '\'' +
				", habilidades='" + habilidades + '\'' +
				", referencias='" + referencias + '\'' +
				", usuario=" + usuario +
				'}';
	}
}
