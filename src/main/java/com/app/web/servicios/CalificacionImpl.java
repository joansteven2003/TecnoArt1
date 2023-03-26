package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Calificacion;
import com.app.web.repositorio.Calificacion_repositorio;

@Service
public class CalificacionImpl implements CalificacionServicio {

	@Autowired
	private Calificacion_repositorio repositorio;

	@Override
	public List<Calificacion> listarCalificacion() {
		return repositorio.findAll();
	}

	@Override
	public Calificacion guardarCalificacion(Calificacion calificacion) {
		return repositorio.save(calificacion);
	}

	@Override
	public Calificacion obtenerCalificacionPorId(long IdCalificacion) {
		return repositorio.findById(IdCalificacion).get();
	}

	@Override
	public Calificacion actualizarCalificacion(Calificacion calificacion) {
		return repositorio.save(calificacion);
	}

	@Override
	public void eliminarCalificacion(long IdCalificacion) {
		repositorio.deleteById(IdCalificacion);
	}

}
