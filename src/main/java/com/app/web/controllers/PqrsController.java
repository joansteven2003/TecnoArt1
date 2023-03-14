package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.modelos.Pqrs;
import com.app.web.servicios.PqrsServicio;

@Controller
public class PqrsController {
	@Autowired
	private PqrsServicio servicio;

	@GetMapping("/Pqrs")
	public String listarPqrs(Model modelo) {
		modelo.addAttribute("Pqrs", servicio.listarPQRS());
		return "/Pqrs";
	}

	@GetMapping("/Pqrs/Registrar")
	public String MostrarRegistrarPqrsFormulario(Model modelo) {
		Pqrs pqrs = new Pqrs();
		modelo.addAttribute("Pqrs", pqrs);
		return "crearPqrs";
	}

	@PostMapping("/Guardar")
	public String guardarPqrs(@ModelAttribute("Pqrs") Pqrs pqrs) {
		servicio.guardarPqrs(pqrs);
		return "redirect:/Pqrs";

	}

	@GetMapping("/Pqrs/editar/{IdPqrs}")
	public String mostrarFormularioDeEitar(@PathVariable long IdPqrs, Model modelo) {
		modelo.addAttribute("pqrs", servicio.obtenerPqrsPorId(IdPqrs));
		return "/editarPqrs";
	}

	@PostMapping("/Pqrs/{IdPqrs}")
	public String actualizarPqrs(@PathVariable long IdPqrs, @ModelAttribute("pqrs") Pqrs pqrs, Model modelo) {

		Pqrs pqrsExistente = servicio.obtenerPqrsPorId(IdPqrs);
		pqrsExistente.setIdPqrs(IdPqrs);
		pqrsExistente.setDescripcion(pqrs.getDescripcion());
		pqrsExistente.setFecha(pqrs.getFecha());
		pqrsExistente.setTipo(pqrs.getTipo());
		pqrsExistente.setPrioridad(pqrs.getPrioridad());
		pqrsExistente.setEstado(pqrs.getEstado());
		pqrsExistente.setVenta(pqrs.getVenta());
		pqrsExistente.setRespuestaPqrs(pqrs.getRespuestaPqrs());

		servicio.actualizarPqrs(pqrsExistente);
		return "redirect:/Pqrs";
	}

	@GetMapping("/Pqrs/eliminar/{IdPqrs}")
	public String eliminarPqrs(@PathVariable long IdPqrs) {
		servicio.eliminarPqrs(IdPqrs);
		return "redirect:/Pqrs";
	}

}
