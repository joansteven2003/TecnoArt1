package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.web.servicios.PqrsServicio;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Autowired
	private PqrsServicio servicio;

	@GetMapping("/")
	public String index(Model modelo) {

		return "/index";
	}

	@GetMapping("/index_Cliente")
	public String indexCliente(Model modelo) {

		return "/Cliente_index";
	}

	@GetMapping("/Bienvenida")
	public String TablasBienvenida(Model modelo) {

		return "/Tablas_Bienvenida";
	}
	
	@GetMapping("/conocenos")
	public String conocenos(Model modelo) {

		return "/acerca_de_nosotros";
	}

	@GetMapping("/TrabajaConNosotros")
	public String TrabajaConNosotros (Model modelo) {
		return "/trabaja_con_nosotros";
	}

	@GetMapping("/NuestroTrabajo")
	public String NuestroTrabajo (Model modelo) {
		return "/nuestros_trabajos";
	}
	@GetMapping("/login")
	public String iniciarSesion(Model modelo) {

		return "/login";
	}

	@GetMapping("/Registrarse")
	public String Registrarse(Model modelo) {

		return "/Registrarse.html";
	}
}
