package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Calificacion;

public interface CalificacionServicio {

	public List<Calificacion> listarCalificacion();

	public Calificacion guardarCalificacion(Calificacion calificacio);

	public Calificacion obtenerCalificacionPorId(long IdCalificacion);

	public Calificacion actualizarCalificacion(Calificacion calificacio);

	public void eliminarCalificacion(long IdCalificacion);

}
