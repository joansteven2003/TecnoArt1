package com.app.web.modelos;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdUsuario;

	@Column(name = "Nombre", nullable = true)
	private String Nombre;
	@Column(name = "Apellido", nullable = true)
	private String Apellido;
	@Column(name = "Documento", nullable = true)
	private long Documento;
	@Column(name = "Telefono", nullable = true)
	private long Telefono;
	@Column(name = "Correo", nullable = true)
	private String Correo;
	@Column(name = "Recidencia", nullable = true)
	private String Recidencia;
	@Column(name = "password", nullable = true)
	private String password;

	@OneToMany(mappedBy = "usuario")
	List<Venta> ListVenta;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<Rol> roles;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	public Usuario() {
		super();
	}

	public Usuario(long idUsuario, String nombre, String apellido, long documento, long telefono, String correo,
			String recidencia, String password, List<Venta> listVenta, Set<Rol> roles, Cargo cargo) {
		super();
		IdUsuario = idUsuario;
		Nombre = nombre;
		Apellido = apellido;
		Documento = documento;
		Telefono = telefono;
		Correo = correo;
		Recidencia = recidencia;
		this.password = password;
		ListVenta = listVenta;
		this.roles = roles;
		this.cargo = cargo;
	}

	public long getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		IdUsuario = idUsuario;
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

	public long getDocumento() {
		return Documento;
	}

	public void setDocumento(long documento) {
		Documento = documento;
	}

	public long getTelefono() {
		return Telefono;
	}

	public void setTelefono(long telefono) {
		Telefono = telefono;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getRecidencia() {
		return Recidencia;
	}

	public void setRecidencia(String recidencia) {
		Recidencia = recidencia;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Venta> getListVenta() {
		return ListVenta;
	}

	public void setListVenta(List<Venta> listVenta) {
		ListVenta = listVenta;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Usuario [IdUsuario=" + IdUsuario + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Documento="
				+ Documento + ", Telefono=" + Telefono + ", Correo=" + Correo + ", Recidencia=" + Recidencia
				+ ", password=" + password + ", ListVenta=" + ListVenta + ", roles=" + roles + ", cargo=" + cargo + "]";
	}

}
