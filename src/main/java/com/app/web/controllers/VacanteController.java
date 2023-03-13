package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.modelos.Aspirante;
import com.app.web.modelos.Vacante;
import com.app.web.servicios.AspiranteServicio;
import com.app.web.servicios.VacanteServicio;

@Controller
public class VacanteController {
	@Autowired
	private VacanteServicio servicio;
	
	@GetMapping("/Vacante")
	public String ListaVacantes(Model modelo) {
		modelo.addAttribute("Vacante", servicio.ListaTodosLosVacantes());
		return "/Vacante";
	}
	
	@GetMapping("/Vacante/eliminar/{IdVacante}")
	public String eliminarVacante(@PathVariable long IdVacante) {
		servicio.eliminarVacante(IdVacante);
		return "redirect:/Vacante";
	}
		//experimentos//
		
	@GetMapping("/Vacante/Registrar")
	public String VacanteFormulario(Model modelo) {
		Vacante vacante = new Vacante();
		modelo.addAttribute("Vacante", vacante);
		return "/crearVacante";
	}

	@PostMapping("/Vacante")
	public String guardarVacante(@ModelAttribute("Vacante") Vacante vacante) {
		servicio.guardarVacante(vacante);
		return "redirect:/Vacante";

	}

	@GetMapping("/Vacante/editar/{IdVacante}")
	public String EditarVacanteFomulario(@PathVariable long IdVacante, Model modelo) {
		modelo.addAttribute("Vacante", servicio.obtenerVacantePorId(IdVacante));
		return "/editarVacante";
	}

	@PostMapping("/Vacante/{IdVacante}")
	public String EditarVacante(@PathVariable long IdVacante, @ModelAttribute("Vacante") Vacante vacante,
			Model modelo) {

		Vacante VacanteExistente = servicio.obtenerVacantePorId(IdVacante);
		VacanteExistente.setIdVacante(IdVacante);
		VacanteExistente.setHoraInicio(vacante.getHoraInicio());
		VacanteExistente.setHoraFin(vacante.getHoraFin());
		VacanteExistente.setPerfil(vacante.getPerfil());
		VacanteExistente.setLugarTrabajo(vacante.getLugarTrabajo());
		VacanteExistente.setDescripcion(vacante.getDescripcion());
		VacanteExistente.setSalario(vacante.getSalario());
		VacanteExistente.setEduacion(vacante.getEduacion());
		VacanteExistente.setCargo(vacante.getCargo());
		VacanteExistente.setAspirante(vacante.getAspirante());
		

		servicio.actualizarVacante(VacanteExistente);
		return "redirect:/Vacante";
	}
}
