package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Tipo;
import com.app.web.repositorio.Tipo_repositorio;

@Service
public class TipoImpl implements TipoServicio {
	@Autowired
	private Tipo_repositorio repositorio;

	@Override
	public List<Tipo> listarTipo() {

		return repositorio.findAll();
	}

	@Override
	public Tipo guardarTipo(Tipo tipo) {
		return repositorio.save(tipo);
	}

	@Override
	public Tipo obtenerTipoPorId(long IdTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipo actualizarTipo(Tipo tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarTipo(long IdTipo) {
		// TODO Auto-generated method stub
		
	}
}
