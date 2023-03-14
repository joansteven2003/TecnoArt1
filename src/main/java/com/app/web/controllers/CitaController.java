package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.modelos.Cita;
import com.app.web.servicios.CitaServicio;

@Controller
public class CitaController {
	@Autowired
	private CitaServicio servicio;
	
	@GetMapping("/Cita")
	public String ListaTodasLasCitas(Model modelo) {
		modelo.addAttribute("Cita", servicio.listarTodasLasCitas());
		return "/Cita";
	}
	
	@GetMapping("/Cita/eliminar/{IdCita}")
	public String eliminarCita(@PathVariable long IdCita) {
		servicio.eliminarCita(IdCita);
		return "redirect:/Cita";
	}
		//experimentos//
		
	@GetMapping("/Cita/Registrar")
	public String CitaFormulario(Model modelo) {
		Cita cita = new Cita();
		modelo.addAttribute("Cita", cita);
		return "/crearCita";
	}

	@PostMapping("/Guardar")
	public String guardarCita(@ModelAttribute("Cita") Cita cita) {
		servicio.guardarCita(cita);
		return "redirect:/Cita";

	}

	@GetMapping("/Cita/editar/{IdCita}")
	public String EditarCitaFomulario(@PathVariable long IdCita, Model modelo) {
		modelo.addAttribute("Cita", servicio.obtenerCitaPorId(IdCita));
		return "/editarCita";
	}

	@PostMapping("/Cita/{IdCita}")
	public String EditarCita(@PathVariable long IdCita, @ModelAttribute("Cita") Cita cita,
			Model modelo) {

		Cita CitaExistente = servicio.obtenerCitaPorId(IdCita);
		CitaExistente.setIdCita(IdCita);
		CitaExistente.setDireccion(cita.getDireccion());
		CitaExistente.setFecha(cita.getFecha());
		CitaExistente.setHora(cita.getHora());
		CitaExistente.setUsuario(cita.getUsuario());
		

		servicio.actualizarCita(CitaExistente);
		return "redirect:/Cita";
	}
		
}
