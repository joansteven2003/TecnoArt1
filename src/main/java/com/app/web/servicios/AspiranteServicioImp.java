package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Aspirante;
import com.app.web.repositorio.AspiranteRepositorio;

@Service
public class AspiranteServicioImp implements AspiranteServicio {

	@Autowired
	private AspiranteRepositorio aspiranterep;

	@Override
	public List<Aspirante> ListaTodosLosAspirantes() {
		return aspiranterep.findAll();
	}

	@Override
	public Aspirante guardarAspirante(Aspirante aspirante) {

		return aspiranterep.save(aspirante);
	}

	@Override
	public Aspirante actualizarAspirante(Aspirante aspirante) {

		return aspiranterep.save(aspirante);
	}

	@Override
	public void eliminarAspirante(Long idaspirante) {
		aspiranterep.deleteById(idaspirante);

	}

	@Override
	public Aspirante obtenerAspirantePorId(Long idaspirante) {
		return aspiranterep.findById(idaspirante).get();

	}
	

}
