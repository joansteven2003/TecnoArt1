package com.app.web.servicios;

import com.app.web.modelos.Cotizacion;

import java.util.List;

public interface CotizacionServicio {
    List<Cotizacion> ListarCotizaciones();

    public Cotizacion guardarCotizacion (Cotizacion cotizacion);

    public Cotizacion  obtenerCotizacionPorId(Long IdCotizacion );

    public Cotizacion actualizarCotizacion (Cotizacion cotizacion);

    public void eliminarCotizacion(Long IdContrato );
}
