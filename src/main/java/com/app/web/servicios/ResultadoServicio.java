package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Resultado;

public interface ResultadoServicio {

public List<Resultado>ListaTodoLosResultados();
	
	public Resultado guardarResultado (Resultado resultado);
	
	public Resultado  obtenerResultadoPorId(Long IdResultado );
	
	public Resultado actualizarResultado (Resultado resultado);
	
	public void eliminarResultado(Long IdResultado);

}
