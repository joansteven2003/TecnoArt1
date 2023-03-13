package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Estado;

public interface EstadoServicio {
	public List<Estado> listarEstado();
	public Estado guardarEstado(Estado estados);

	public Estado obtenerEstadoPorId(long IdEstado);

	public Estado actualizarEstado(Estado estados);

	public void eliminarEstado(long IdEstado);
}
