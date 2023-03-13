package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Cargo;
import com.app.web.repositorio.CargoRepositorio;

@Service
public class CargoServiciolmp implements CargoServicio {
	
	@Autowired
	private CargoRepositorio repositorio;
	
	@Override
	public List<Cargo> ListaTodoLosCargos() {
		return repositorio.findAll();
	}

	@Override
	public Cargo guardarCargo(Cargo cargo) {
		return repositorio.save(cargo);
	}

	@Override
	public Cargo obtenerCargoPorId(Long IdCargo) {
		return repositorio.findById(IdCargo).get();
	}

	@Override
	public Cargo actualizarCargo(Cargo cargo) {
		return repositorio.save(cargo);
	}

	@Override
	public void eliminar(Long IdCargo) {
		repositorio.deleteById(IdCargo);	
		
	}
	


}
