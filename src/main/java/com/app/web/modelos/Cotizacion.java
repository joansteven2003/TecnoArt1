package com.app.web.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cotizacion")
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCotizacion;

    @Column(name = "Fecha", nullable = false, length = 20)
    private Date Fecha;

    @Column(name = "Descriocion", nullable = false, length = 20)
    private String Descriocion;

    @Column(name = "Respuesta", nullable = true, length = 20)
    private String Respuesta;

    @Column(name = "FechaRespuesta", nullable = true, length = 20)
    private Date FechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "Usuario")
    private Usuario Usuario;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    public Cotizacion() {
    }

    public Cotizacion(Long idCotizacion, Date fecha, String descriocion, String respuesta, Date fechaRespuesta, com.app.web.modelos.Usuario usuario, Venta venta) {
        IdCotizacion = idCotizacion;
        Fecha = fecha;
        Descriocion = descriocion;
        Respuesta = respuesta;
        FechaRespuesta = fechaRespuesta;
        Usuario = usuario;
        this.venta = venta;
    }

    public Long getIdCotizacion() {
        return IdCotizacion;
    }

    public void setIdCotizacion(Long idCotizacion) {
        IdCotizacion = idCotizacion;
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

    public com.app.web.modelos.Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(com.app.web.modelos.Usuario usuario) {
        Usuario = usuario;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "IdCotizacion=" + IdCotizacion +
                ", Fecha=" + Fecha +
                ", Descriocion='" + Descriocion + '\'' +
                ", Respuesta='" + Respuesta + '\'' +
                ", FechaRespuesta=" + FechaRespuesta +
                ", Usuario=" + Usuario +
                ", venta=" + venta +
                '}';
    }
}
