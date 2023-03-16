package com.app.web.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cotizacion")
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCotizacion;
    @OneToOne
    @JoinColumn(name = "Usuario")
    private Usuario usuario;
    @Column(name = "Fecha", nullable = false, length = 20)
    private Date Fecha;

    @Column(name = "Descriocion", nullable = false, length = 20)
    private String Descriocion;

    @Column(name = "Respuesta", nullable = false, length = 20)
    private String Respuesta;

    @Column(name = "FechaRespuesta", nullable = false, length = 20)
    private Date FechaRespuesta;

    public Cotizacion() {
    }

    public Cotizacion(Long idCotizacion, Usuario usuario, Date fecha, String descriocion, String respuesta, Date fechaRespuesta) {
        IdCotizacion = idCotizacion;
        this.usuario = usuario;
        Fecha = fecha;
        Descriocion = descriocion;
        Respuesta = respuesta;
        FechaRespuesta = fechaRespuesta;
    }

    public Long getIdCotizacion() {
        return IdCotizacion;
    }

    public void setIdCotizacion(Long idCotizacion) {
        IdCotizacion = idCotizacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getDescriocion() {
        return Descriocion;
    }

    public void setDescriocion(String descriocion) {
        Descriocion = descriocion;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String respuesta) {
        Respuesta = respuesta;
    }

    public Date getFechaRespuesta() {
        return FechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        FechaRespuesta = fechaRespuesta;
    }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "IdCotizacion=" + IdCotizacion +
                ", usuario=" + usuario +
                ", Fecha=" + Fecha +
                ", Descriocion='" + Descriocion + '\'' +
                ", Respuesta='" + Respuesta + '\'' +
                ", FechaRespuesta=" + FechaRespuesta +
                '}';
    }
}
