package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.modelos.Aspirante;
import com.app.web.modelos.Servicio;
import com.app.web.servicios.ServiciosServicio;

@Controller
public class ServicioController {
	@Autowired
	private ServiciosServicio servicios;

	@GetMapping("/Servicio")
	public String listarServicios(Model modelo) {
		modelo.addAttribute("Servicio", servicios.listarServicios());
		return "/Servicio";
	}

	@GetMapping("/Servicio/Registrar")
	public String mostrarFormularioRegistroServicio(Model modelo) {
		Servicio servicio = new Servicio();
		modelo.addAttribute("Servicio", servicio);
		return "/crearServicio";
	}

	@PostMapping("/Servicio")
	public String guardarServicio(@ModelAttribute("Servicio") Servicio servicio) {
		servicios.guardarServicio(servicio);
		return "redirect:/Aspirante";
	}

	@GetMapping("/Servicio/editar/{IdServicio}")
	public String mostrarFormularioDeEditar(@PathVariable Long IdServicio, Model modelo) {
		modelo.addAttribute("Servicio", servicios.obtenerServicioPorId(IdServicio));
		return "/editarServicio";
	}

	@PostMapping("/Servicio/{IdServicio}")
	public String actualizarServicios(@PathVariable Long IdServicio, @ModelAttribute("Servicio") Servicio servicio,
			Model modelo) {
		Servicio servicioExistente = servicios.obtenerServicioPorId(IdServicio);
		servicioExistente.setIdServicio(IdServicio);
		servicioExistente.setNombre_servicio(servicio.getNombre_servicio());
		servicioExistente.setValor_venta(servicio.getValor_venta());
		servicioExistente.setDescripcion(servicio.getDescripcion());
		servicioExistente.setListarVenta(servicio.getListarVenta());

		servicios.actualizarServicios(servicioExistente);
		return "redirect:/Servicio";

	}

	@GetMapping("/Servicio/{IdServicio}")
	public String eliminarServicios(@PathVariable Long IdServicio) {
		servicios.eliminarServicios(IdServicio);
		return "redirect:/Servicio";
	}
}
