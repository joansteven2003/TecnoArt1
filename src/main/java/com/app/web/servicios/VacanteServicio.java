package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Vacante;

public interface VacanteServicio {

	public List<Vacante> ListaTodosLosVacantes();

	public Vacante guardarVacante(Vacante vacante);

	public Vacante obtenerVacantePorId(Long IdVacante);

	public Vacante actualizarVacante(Vacante vacante);

	public void eliminarVacante(Long IdVacante);
}
