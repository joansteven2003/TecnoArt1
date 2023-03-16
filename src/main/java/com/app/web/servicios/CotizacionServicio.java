package com.app.web.servicios;

import com.app.web.modelos.Cotizacion;

import java.util.List;

public interface CotizacionServicio {
    List<Cotizacion> ListaTodoLosContratos();

    public Cotizacion guardarContrato (Cotizacion cotizacion);

    public Cotizacion  obtenerContratoPorId(Long IdContrato );

    public Cotizacion actualizarContrato (Cotizacion cotizacion);

    public void eliminarContrato(Long IdContrato );
}
