package com.app.web.controllers;

import com.app.web.modelos.Venta;
import com.app.web.servicios.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.modelos.Calificacion;
import com.app.web.servicios.CalificacionServicio;

import java.util.List;

@Controller
public class CalificacionContrller {
	@Autowired
	private CalificacionServicio servicio;
	@Autowired
	private VentaServicio ServicioVenta;
	
	@GetMapping("/Calificacion")
	public String ListarCalificaciones(Model modelo) {
		modelo.addAttribute("Calificacion", servicio.listarCalificacion());
		return "/Calificacion";
	}
	
	@GetMapping("/Calificacion/eliminar/{IdCalificacion}")
	public String eliminarCalificacion(@PathVariable long IdCalificacion) {
		servicio.eliminarCalificacion(IdCalificacion);
		return "redirect:/Calificacion";
	}
		//experimentos//
		
	@GetMapping("/Calificacion/Registrar")
	public String CalificacionFormulario(Model modelo) {
		Calificacion calificacion = new Calificacion();
		List<Venta> listaVenta = ServicioVenta.listarVentas();

		modelo.addAttribute("Calificacion", calificacion);
		modelo.addAttribute("ventas", listaVenta);
		return "/Generar_Calificacion";
	}

	@PostMapping("/Calificacion/Guardar")
	public String guardarCalificacion(@ModelAttribute("Calificacion") Calificacion calificacion) {
		servicio.guardarCalificacion(calificacion);
		return "redirect:/Generar_Calificacion";

	}

	@GetMapping("/Calificacion/editar/{idaspirante}")
	public String EditarCalificacionFomulario(@PathVariable long IdCalificacion, Model modelo) {
		modelo.addAttribute("Calificacion", servicio.obtenerCalificacionPorId(IdCalificacion));
		return "/Editar_Calificacion";
	}

	@PostMapping("/Calificacion/{IdCalificacion}")
	public String EditarCalificacion(@PathVariable long IdCalificacion, @ModelAttribute("Calificacion") Calificacion calificacion,
			Model modelo) {

		Calificacion CalificacionExistente = servicio.obtenerCalificacionPorId(IdCalificacion);
		CalificacionExistente.setIdCalificacion(IdCalificacion);
		CalificacionExistente.setEstrellas(calificacion.getEstrellas());
		calificacion.setVenta(calificacion.getVenta());
		

		servicio.actualizarCalificacion(CalificacionExistente);
		return "redirect:/Calificacion";
	}
}
