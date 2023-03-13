package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Venta;
import com.app.web.repositorio.VentaRepositorio;

@Service
public class VentaServicioImpl implements VentaServicio {

	@Autowired
	private VentaRepositorio repositorio;

	@Override
	public List<Venta> listarVentas() {
		return repositorio.findAll();
	}

	@Override
	public Venta guardarVenta(Venta venta) {
		return repositorio.save(venta);
	}

	@Override
	public Venta obtenerVentaPorId(Long IdVenta) {
		return repositorio.findById(IdVenta).get();
	}

	@Override
	public Venta actualizarVenta(Venta venta) {
		return repositorio.save(venta);
	}

	@Override
	public void eliminarVenta(Long IdVenta) {
		repositorio.deleteById(IdVenta);

	}

}
