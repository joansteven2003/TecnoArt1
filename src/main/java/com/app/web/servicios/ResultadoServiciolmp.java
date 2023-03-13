package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Resultado;
import com.app.web.repositorio.ResultadoRepositorio;

@Service
public class ResultadoServiciolmp implements ResultadoServicio {

	@Autowired
	private ResultadoRepositorio repositorio;

	
	
	@Override
	public List<Resultado> ListaTodoLosResultados() {
		return repositorio.findAll();
	}

	@Override
	public Resultado guardarResultado(Resultado resultado) {
		return repositorio.save(resultado);
	}

	@Override
	public Resultado obtenerResultadoPorId(Long IdResultado) {
		return repositorio.findById(IdResultado).get();
	}

	@Override
	public Resultado actualizarResultado(Resultado resultado) {
		return repositorio.save(resultado);
	}

	@Override
	public void eliminarResultado(Long IdResultado) {
		repositorio.deleteById(IdResultado);	
		
	}

}
