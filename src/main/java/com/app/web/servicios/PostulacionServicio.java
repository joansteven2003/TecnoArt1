package com.app.web.servicios;

import com.app.web.modelos.Postulacion;
import com.app.web.modelos.Pqrs;

import java.util.List;

public interface PostulacionServicio {

    public List<Postulacion> listarPostulacion();

    public Postulacion guardarPostulacion(Postulacion postulacion);

    public Postulacion obtenerPostulacionPorId(long IdPostulacion);

    public Postulacion actualizarPostulacion(Postulacion postulacion);

    public void eliminarPostulacion(long IdPostulacion);
}
