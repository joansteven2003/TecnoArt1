package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.modelos.Pqrs;
import com.app.web.repositorio.Pqrs_Repositorio;

@Service
public class PqrsServicioImpl implements PqrsServicio {

	@Autowired
	private Pqrs_Repositorio repositorio;

	@Override
	public List<Pqrs> listarPQRS() {

		return repositorio.findAll();
	}

	@Override
	public Pqrs guardarPqrs(Pqrs pqrs) {
		return repositorio.save(pqrs);
	}

	@Override
	public Pqrs obtenerPqrsPorId(long IdPqrs) {
		Pqrs pqrs = repositorio.findById(IdPqrs).get();
		System.out.println("@@#pqr "+ pqrs.toString());
		return pqrs;
	}

	@Override
	public Pqrs actualizarPqrs(Pqrs pqrs) {
		return repositorio.save(pqrs);
	}

	@Override
	public void eliminarPqrs(long IdPqrs) {
		repositorio.deleteById(IdPqrs);

	}

}
