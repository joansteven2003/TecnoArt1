package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Contrato;

public interface ContratoServicios {

public List<Contrato> ListaTodoLosContratos();
	
	public Contrato guardarContrato (Contrato contrato);
	
	public Contrato  obtenerContratoPorId(Long IdContrato );
	
	public Contrato actualizarContrato (Contrato contrato);
	
	public void eliminarContrato(Long IdContrato );

}
