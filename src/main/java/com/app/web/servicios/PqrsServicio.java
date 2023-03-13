package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Pqrs;

public interface PqrsServicio {

	public List<Pqrs> listarPQRS();

	public Pqrs guardarPqrs(Pqrs pqrs);

	public Pqrs obtenerPqrsPorId(long IdPqrs);

	public Pqrs actualizarPqrs(Pqrs pqrs);

	public void eliminarPqrs(long IdPqrs);

}
