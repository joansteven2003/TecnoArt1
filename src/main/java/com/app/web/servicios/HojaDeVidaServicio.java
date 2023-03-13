package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.HojaDeVida;

public interface HojaDeVidaServicio {

	public List<HojaDeVida>ListaTodosHojadevida();
	
	public HojaDeVida guardarHojadevida(HojaDeVida hojaDeVida);
	
	public HojaDeVida obtenerHojadevidaPorId(long IdHojaDeVida);

	public HojaDeVida actualizarHojadevida(HojaDeVida hojaDeVida);

	public void eliminarHojadevida(long IdHojaDeVida);
}
