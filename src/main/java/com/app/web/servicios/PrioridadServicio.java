package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Prioridad;

public interface PrioridadServicio {
	public List<Prioridad> listarPrioridad();
	
	public Prioridad guardarPrioridad(Prioridad prioridad);

	public Prioridad obtenerPrioridadPorId(long IdPrioridad);

	public Prioridad actualizarPrioridad(Prioridad prioridad);

	public void eliminarPrioridad(long IdPrioridad);
}
