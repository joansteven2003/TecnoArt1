package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.web.servicios.PqrsServicio;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IndexController {
	@Autowired
	private PqrsServicio servicio;

	@GetMapping("/index")
	public String index(Model modelo) {

		return "/index";
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

	@GetMapping("/Registrarse")
	public String Registrarse(Model modelo) {

		return "/Registrarse.html";
	}


}
