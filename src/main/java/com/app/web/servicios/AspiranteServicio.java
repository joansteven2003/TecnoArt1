package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Aspirante;

public interface AspiranteServicio {

	public List<Aspirante> ListaTodosLosAspirantes();

	public Aspirante guardarAspirante(Aspirante aspirante);

	public Aspirante obtenerAspirantePorId(Long idaspirante);

	public Aspirante actualizarAspirante(Aspirante aspirante);

	public void eliminarAspirante(Long idaspirante);

}
