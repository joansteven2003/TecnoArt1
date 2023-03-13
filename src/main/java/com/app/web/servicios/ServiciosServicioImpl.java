package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Servicio;
import com.app.web.repositorio.ServicioRepositorio;

@Service
public class ServiciosServicioImpl implements ServiciosServicio {

	@Autowired
	private ServicioRepositorio repositorio;

	@Override
	public List<Servicio> listarServicios() {
		return repositorio.findAll();
	}

	@Override
	public Servicio guardarServicio(Servicio servicioo) {
		return repositorio.save(servicioo);
	}

	@Override
	public Servicio obtenerServicioPorId(Long IdServicio) {
		return repositorio.findById(IdServicio).get();
	}

	@Override
	public Servicio actualizarServicios(Servicio servicioo) {
		return repositorio.save(servicioo);
	}

	@Override
	public void eliminarServicios(Long IdServicio) {
		repositorio.deleteById(IdServicio);

	}

}
