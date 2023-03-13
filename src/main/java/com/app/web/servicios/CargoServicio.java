package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Cargo;

public interface CargoServicio {

public List<Cargo> ListaTodoLosCargos();
	
	public Cargo guardarCargo (Cargo cargo);
	
	public Cargo  obtenerCargoPorId(Long IdCargo);
	
	public Cargo actualizarCargo (Cargo cargo);
	
	public void eliminar(Long IdCargo );
}
