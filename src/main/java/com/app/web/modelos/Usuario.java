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
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "Recidencia", nullable = true)
    private String Recidencia;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(name = "password", nullable = true)
    private String password;


    @OneToMany(mappedBy = "usuario")
    List<Venta> ListVenta;

    @ManyToOne
    @JoinColumn(name = "Rol")
    private Rol rol;
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

    public Usuario(long idUsuario, String nombreCompleto, long documento, long telefono, String email, String recidencia, Boolean enabled, String password, List<Venta> listVenta, Rol rol, HojaDeVida hojaDeVida, Cotizacion cotizacion, Contrato contrato, Postulacion postulacion) {
        IdUsuario = idUsuario;
        NombreCompleto = nombreCompleto;
        Documento = documento;
        Telefono = telefono;
        this.email = email;
        Recidencia = recidencia;
        this.enabled = enabled;
        this.password = password;
        ListVenta = listVenta;
        this.rol = rol;
        this.hojaDeVida = hojaDeVida;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecidencia() {
        return Recidencia;
    }

    public void setRecidencia(String recidencia) {
        Recidencia = recidencia;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public HojaDeVida getHojaDeVida() {
        return hojaDeVida;
    }

    public void setHojaDeVida(HojaDeVida hojaDeVida) {
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

    @Override
    public String toString() {
        return "Usuario{" +
                "IdUsuario=" + IdUsuario +
                ", NombreCompleto='" + NombreCompleto + '\'' +
                ", Documento=" + Documento +
                ", Telefono=" + Telefono +
                ", email='" + email + '\'' +
                ", Recidencia='" + Recidencia + '\'' +
                ", enabled=" + enabled +
                ", password='" + password + '\'' +
                ", ListVenta=" + ListVenta +
                ", rol=" + rol +
                ", hojaDeVida=" + hojaDeVida +
                ", cotizacion=" + cotizacion +
                ", contrato=" + contrato +
                ", postulacion=" + postulacion +
                '}';
    }
}