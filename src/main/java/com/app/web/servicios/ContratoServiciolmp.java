package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Contrato;
import com.app.web.repositorio.ContratoRepositorio;

@Service
public class ContratoServiciolmp implements ContratoServicios {
	@Autowired
	private ContratoRepositorio repositorio;
	
	@Override
	public List<Contrato> ListaTodoLosContratos() {
		return repositorio.findAll();
	}

	@Override
	public Contrato guardarContrato(Contrato contrato) {
		return repositorio.save(contrato);
	}

	@Override
	public Contrato obtenerContratoPorId(Long IdContrato) {
		return repositorio.findById(IdContrato).get();
	}

	@Override
	public Contrato actualizarContrato(Contrato contrato) {
		return repositorio.save(contrato);
	}

	@Override
	public void eliminarContrato(Long IdContrato) {
		repositorio.deleteById(IdContrato);
		
	}

}
