package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Venta;

public interface VentaServicio {

	public List<Venta> listarVentas();

	public Venta guardarVenta(Venta venta);

	public Venta obtenerVentaPorId(Long IdVenta);

	public Venta actualizarVenta(Venta venta);

	public void eliminarVenta(Long IdVenta);
}
