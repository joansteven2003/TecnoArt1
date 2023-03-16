package com.app.web.servicios;

import com.app.web.modelos.Cotizacion;
import com.app.web.repositorio.ContratoRepositorio;
import com.app.web.repositorio.CotizacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotizacionServicioImpl implements CotizacionServicio {

    @Autowired
    private CotizacionRepositorio repositorio;
    @Override
    public List<Cotizacion> ListarCotizaciones() {
        return repositorio.findAll();
    }

    @Override
    public Cotizacion guardarCotizacion(Cotizacion cotizacion) {
        return repositorio.save(cotizacion);
    }

    @Override
    public Cotizacion obtenerCotizacionPorId(Long IdCotizacion) {
        return repositorio.findById(IdCotizacion).get();
    }

    @Override
    public Cotizacion actualizarCotizacion(Cotizacion cotizacion) {
        return repositorio.save(cotizacion);
    }

    @Override
    public void eliminarCotizacion(Long IdContrato) {
        repositorio.deleteById(IdContrato);

    }
}
