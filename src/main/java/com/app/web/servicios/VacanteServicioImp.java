package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Vacante;
import com.app.web.repositorio.VacanteRepositorio;

@Service
public class VacanteServicioImp implements VacanteServicio {

	@Autowired
	private VacanteRepositorio repositorio;

	@Override
	public List<Vacante> ListaTodosLosVacantes() {
		return repositorio.findAll();
	}

	@Override
	public Vacante guardarVacante(Vacante vacante) {

		return repositorio.save(vacante);
	}

	@Override
	public Vacante actualizarVacante(Vacante vacante) {

		return repositorio.save(vacante);
	}

	@Override
	public void eliminarVacante(Long IdVacante) {
		repositorio.deleteById(IdVacante);

	}

	@Override
	public Vacante obtenerVacantePorId(Long IdVacante) {
		return repositorio.findById(IdVacante).get();

	}

}
