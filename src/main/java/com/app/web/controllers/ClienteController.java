package com.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
	
	@GetMapping("/cliente/index_Cliente")
	public String indexCliente(Model modelo) {

		return "/Cliente_index";
	}
	
	@GetMapping("/cliente/conocenos")
	public String conocenos(Model modelo) {

		return "/Cliente_acerca_de_nosotros";
	}

	@GetMapping("/cliente/TrabajaConNosotros")
	public String TrabajaConNosotros (Model modelo) {
		return "/Cliente_trabaja_con_nosotros";
	}

	@GetMapping("/cliente/NuestroTrabajo")
	public String NuestroTrabajo (Model modelo) {
		return "/cliente_nuestros_trabajos";
	}
	@GetMapping("/cliente/Bienvenida")
	public String bienvenidaCliente (Model modelo) {
		return "/bienvenidaCliente";
	}


}
