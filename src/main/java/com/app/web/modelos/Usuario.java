package com.app.web.modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdUsuario;

	@Column(name = "NombreCompleto", nullable = true)
	private String NombreCompleto;
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

	@Lob
	@Column(name = "HojaDeVida", nullable = true)
	private byte[] HojaDeVida;

	@OneToMany(mappedBy = "usuario")
	List<Venta> ListVenta;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<Rol> roles;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private HojaDeVida hojaDeVida;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Cotizacion cotizacion;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Contrato contrato;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Postulacion postulacion;

	public Usuario() {
	}

    public Usuario(long idUsuario, String nombreCompleto, long documento, long telefono, String correo, String recidencia, String password, byte[] hojaDeVida, List<Venta> listVenta, Set<Rol> roles, com.app.web.modelos.HojaDeVida hojaDeVida1, Cotizacion cotizacion, Contrato contrato, Postulacion postulacion) {
        IdUsuario = idUsuario;
        NombreCompleto = nombreCompleto;
        Documento = documento;
        Telefono = telefono;
        Correo = correo;
        Recidencia = recidencia;
        this.password = password;
        HojaDeVida = hojaDeVida;
        ListVenta = listVenta;
        this.roles = roles;
        this.hojaDeVida = hojaDeVida1;
        this.cotizacion = cotizacion;
        this.contrato = contrato;
        this.postulacion = postulacion;
    }

    public long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
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

    public byte[] getHojaDeVida() {
        return HojaDeVida;
    }

    public void setHojaDeVida(com.app.web.modelos.HojaDeVida hojaDeVida) {
        this.hojaDeVida = hojaDeVida;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Postulacion getPostulacion() {
        return postulacion;
    }

    public void setPostulacion(Postulacion postulacion) {
        this.postulacion = postulacion;
    }

    public void setHojaDeVida(byte[] hojaDeVida) {
        HojaDeVida = hojaDeVida;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "IdUsuario=" + IdUsuario +
                ", NombreCompleto='" + NombreCompleto + '\'' +
                ", Documento=" + Documento +
                ", Telefono=" + Telefono +
                ", Correo='" + Correo + '\'' +
                ", Recidencia='" + Recidencia + '\'' +
                ", password='" + password + '\'' +
                ", HojaDeVida=" + Arrays.toString(HojaDeVida) +
                ", ListVenta=" + ListVenta +
                ", roles=" + roles +
                ", hojaDeVida=" + hojaDeVida +
                ", cotizacion=" + cotizacion +
                ", contrato=" + contrato +
                ", postulacion=" + postulacion +
                '}';
    }
}
