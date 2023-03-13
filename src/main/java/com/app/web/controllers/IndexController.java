package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.web.servicios.PqrsServicio;

@Controller
public class IndexController {
	@Autowired
	private PqrsServicio servicio;

	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("pqrs", servicio.listarPQRS());
		return "/index";
	}
	
	@GetMapping("/conocenos")
	public String conocenos(Model modelo) {
		modelo.addAttribute("pqrs", servicio.listarPQRS());
		return "/conocenos"; 
	}
	@GetMapping("/iniciosesion")
	public String iniciarSesion(Model modelo) {
		modelo.addAttribute("pqrs", servicio.listarPQRS());
		return "/inicioSesion"; 
	}
}
