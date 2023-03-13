package com.app.web.servicios;

import java.util.List;


import com.app.web.modelos.Cita;

public interface CitaServicio {

	public List<Cita> listarTodasLasCitas();

	public Cita guardarCita(Cita entrevista);

	public Cita obtenerCitaPorId(Long IdCita);

	public Cita actualizarCita(Cita Cita);

	public void eliminarCita(Long idCita);

}
