package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.HojaDeVida;
import com.app.web.repositorio.HojaDeVidaRepositorio;
@Service 
public class HojaDeVidaServiciolmp implements HojaDeVidaServicio {

	@Autowired
	private HojaDeVidaRepositorio repositorio;
	
	@Override
	public List<HojaDeVida> ListaTodosHojadevida() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public HojaDeVida guardarHojadevida(HojaDeVida hojaDeVida) {
		// TODO Auto-generated method stub
		return repositorio.save(hojaDeVida);
	}

	@Override
	public HojaDeVida obtenerHojadevidaPorId(long IdHojaDeVida) {
		// TODO Auto-generated method stub
		return repositorio.findById(IdHojaDeVida).get();
	}

	@Override
	public HojaDeVida actualizarHojadevida(HojaDeVida hojaDeVida) {
		// TODO Auto-generated method stub
		return repositorio.save(hojaDeVida);
	}

	@Override
	public void eliminarHojadevida(long IdHojaDeVida) {
		// TODO Auto-generated method stub
		repositorio.deleteById(IdHojaDeVida);
	}

}
