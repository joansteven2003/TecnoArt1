package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Tipo;

public interface TipoServicio {
	public List<Tipo> listarTipo();
	
	public Tipo guardarTipo(Tipo tipo);

	public Tipo obtenerTipoPorId(long IdTipo);

	public Tipo actualizarTipo(Tipo tipo);

	public void eliminarTipo(long IdTipo);
}
