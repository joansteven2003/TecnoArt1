package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Prioridad;

import com.app.web.repositorio.Prioridad_repositorio;

@Service
public class PrioridadImpl implements PrioridadServicio {

	@Autowired
	private Prioridad_repositorio repositorio;

	@Override
	public List<Prioridad> listarPrioridad() {

		return repositorio.findAll();
	}

	@Override
	public Prioridad guardarPrioridad(Prioridad prioridad) {
		return repositorio.save(prioridad);
		
	}

	@Override
	public Prioridad obtenerPrioridadPorId(long IdPrioridad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prioridad actualizarPrioridad(Prioridad prioridad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPrioridad(long IdPrioridad) {
		// TODO Auto-generated method stub
		
	}

}
