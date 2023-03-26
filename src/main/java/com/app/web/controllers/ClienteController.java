package com.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

	@GetMapping("/cliente/Bienvenida")
	public String bienvenidaCliente (Model modelo) {

		return "/bienvenidaCliente";
	}


	@GetMapping("/cliente/Calificacion")
	public String ClienteCalificacion (Model modelo) {

		return "/Cliente_Cotizacion";
	}

	@GetMapping("/cliente/Cotizacion")
	public String ClienteCotizacion (Model modelo) {

		return "/Cliente_Cotizacion";
	}

	@GetMapping("/cliente/HojaDeVida")
	public String ClienteHojaDeVida (Model modelo) {

		return "/Cliente_HojaDeVida";
	}

	@GetMapping("/cliente/Pqrs")
	public String ClientePqrs (Model modelo) {

		return "/Cliente_Pqrs";
	}

	@GetMapping("/cliente/Venta")
	public String ClienteVenta (Model modelo) {

		return "/Cliente_Venta";
	}

	@GetMapping("/cliente/GenerarCalificacion")
	public String ClienteGenerarCalificacion (Model modelo) {

		return "/Generar_Calificacion";
	}

	@GetMapping("/cliente/GenerarCotizacion")
	public String ClienteGenerarCotizaciion (Model modelo) {

		return "/Generar_Cotizacion";
	}

	@GetMapping("/cliente/GenerarHojaDeVida")
	public String ClienteGenerarHojaDeVida(Model modelo) {

		return "/Generar_HojaDeVida";
	}

	@GetMapping("/cliente/GenerarPQRS")
	public String ClienteGenerarPQRS(Model modelo) {

		return "/Generar_PQRS";
	}




}
