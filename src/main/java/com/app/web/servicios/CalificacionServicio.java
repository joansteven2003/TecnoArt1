package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Calificacion;

public interface CalificacionServicio {

	public List<Calificacion> listarCalificacion();

	public Calificacion guardarCalificacion(Calificacion calificacion);

	public Calificacion obtenerCalificacionPorId(long IdCalificacion);

	public Calificacion actualizarCalificacion(Calificacion calificacion);

	public void eliminarCalificacion(long IdCalificacion);

}
