package com.app.web.controllers;

import com.app.web.modelos.Cargo;
import com.app.web.servicios.CargoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.modelos.Vacante;
import com.app.web.servicios.VacanteServicio;

import java.util.List;

@Controller
public class VacanteController {
	@Autowired
	private VacanteServicio servicio;

	@Autowired
	private CargoServicio cargoServicio;
	
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
		List<Cargo> ListaCargo = cargoServicio.ListaTodoLosCargos();
		modelo.addAttribute("Vacante", vacante);
		modelo.addAttribute("Cargos",ListaCargo);

		return "/Generar_Vacante";
	}

	@PostMapping("/Vacante/Guardar")
	public String guardarVacante(@ModelAttribute("Vacante") Vacante vacante) {
		servicio.guardarVacante(vacante);
		return "redirect:/Vacante";

	}

	@GetMapping("/Vacante/editar/{IdVacante}")
	public String EditarVacanteFomulario(@PathVariable long IdVacante, Model modelo) {
		modelo.addAttribute("Vacante", servicio.obtenerVacantePorId(IdVacante));
		return "/Editar_Vacante";
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
		VacanteExistente.setPostulacion(vacante.getPostulacion());
		

		servicio.actualizarVacante(VacanteExistente);
		return "redirect:/Vacante";
	}
}
