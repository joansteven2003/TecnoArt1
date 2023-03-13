package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Estado;

import com.app.web.repositorio.Estados_repositorio;

@Service
public class EstadoImpl implements EstadoServicio {
	@Autowired
	private Estados_repositorio repositorio;

	@Override
	public List<Estado> listarEstado() {
		return repositorio.findAll();
	}

	@Override
	public Estado guardarEstado(Estado estado) {
		return repositorio.save(estado);
		
	}

	@Override
	public Estado obtenerEstadoPorId(long IdEstado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado actualizarEstado(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEstado(long IdEstado) {
		// TODO Auto-generated method stub
		
	}

}
