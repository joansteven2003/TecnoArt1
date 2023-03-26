package com.app.web.controllers;

import com.app.web.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

	@Autowired
	private CalificacionServicio servicio;
	@Autowired
	private CotizacionServicio servicio1;
	@Autowired
	private HojaDeVidaServicio servicio2;

	@Autowired
	private PqrsServicio servicio3;

	@Autowired
	private VacanteServicio servicio4;

	@Autowired
	private VentaServicio servicio5;
	@GetMapping("/cliente/Bienvenida")
	public String bienvenidaCliente (Model modelo) {
		return "/bienvenidaCliente";
	}


	@GetMapping("/cliente/Calificacion")
	public String ClienteCalificacion (Model modelo) {
		modelo.addAttribute("Calificacion", servicio.listarCalificacion());
		return "/Cliente_Cotizacion";
	}

	@GetMapping("/cliente/Cotizacion")
	public String ClienteCotizacion (Model modelo) {
		modelo.addAttribute("Cotizacion", servicio1.ListarCotizaciones());
		return "/Cliente_Cotizacion";
	}

	@GetMapping("/cliente/HojaDeVida")
	public String ClienteHojaDeVida (Model modelo) {
		modelo.addAttribute("HojaDeVida", servicio2.ListaTodosHojadevida());
		return "/Cliente_HojaDeVida";
	}

	@GetMapping("/cliente/Pqrs")
	public String ClientePqrs (Model modelo) {
		modelo.addAttribute("Pqrs", servicio3.listarPQRS());
		return "/Cliente_Pqrs";
	}

	@GetMapping("/cliente/Venta")
	public String ClienteVenta (Model modelo) {
		modelo.addAttribute("Venta", servicio5.listarVentas());
		return "/Cliente_Venta";
	}
	@GetMapping("/cliente/Vacante")
	public String ClienteVacante (Model modelo) {
		modelo.addAttribute("Vacante", servicio4.ListaTodosLosVacantes());
		return "/Cliente_Vacante";
	}



}
