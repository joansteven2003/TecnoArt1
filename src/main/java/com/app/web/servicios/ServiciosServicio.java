package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Servicio;

public interface ServiciosServicio {

	public List<Servicio> listarServicios();

	public Servicio guardarServicio(Servicio servicio);

	public Servicio obtenerServicioPorId(Long IdServicio);

	public Servicio actualizarServicios(Servicio servicioo);

	public void eliminarServicios(Long IdServicio);
}
