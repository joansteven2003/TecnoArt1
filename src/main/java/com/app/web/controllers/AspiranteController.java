package com.app.web.controllers;
import com.app.web.modelos.Contrato;
import com.app.web.servicios.ContratoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AspiranteController {
	@Autowired
	private AspiranteServicio servicio;
	@Autowired
	private ContratoServicios ContratoServicio;

	@GetMapping("/Aspirante")
	public String ListaTodosLosAspirantes(Model modelo) {
		modelo.addAttribute("Aspirante", servicio.ListaTodosLosAspirantes());
		return "/Administrador/Aspirante";
	}
	
	@GetMapping("/Aspirante/eliminar/{idaspirante}")
	public String eliminarAspirante(@PathVariable long idaspirante) {
		servicio.eliminarAspirante(idaspirante);
		return "redirect:/Administrador/Aspirante";
	}
		//experimentos//
		
	@GetMapping("/Aspirante/Registrar")
	public String AspiranteFormulario(Model modelo) {
		Aspirante aspirante = new Aspirante();
		List<Contrato> listContratos = ContratoServicio.ListaTodoLosContratos();
		modelo.addAttribute("Aspirante", aspirante);
		modelo.addAttribute("Contrato", listContratos);
		return "/Administrador/crearAspirante";
	}

	@PostMapping("/Guardar")
	public String guardarAspirante(@ModelAttribute Aspirante aspirante) {
		servicio.guardarAspirante(aspirante);
		return "redirect:/Administrador/Aspirante";

	}

	@GetMapping("/Aspirante/editar/{idaspirante}")
	public String EditarAspiranteFomulario(@PathVariable long idaspirante, Model modelo) {
		List<Contrato> listContratos = ContratoServicio.ListaTodoLosContratos();
		modelo.addAttribute("Contrato", listContratos);
		modelo.addAttribute("Aspirante", servicio.obtenerAspirantePorId(idaspirante));
		return "/Administrador/editarAspirante";
	}

	@PostMapping("/Aspirante/{idaspirante}")
	public String EditarAspirante(@PathVariable long idaspirante, @ModelAttribute("Aspirante") Aspirante aspirante,
			Model modelo) {

		Aspirante AspiranteExistente = servicio.obtenerAspirantePorId(idaspirante);
		AspiranteExistente.setIdaspirante(idaspirante);
		AspiranteExistente.setNumDocumento(aspirante.getNumDocumento());
		AspiranteExistente.setTipoDC(aspirante.getTipoDC());
		AspiranteExistente.setCorreo(aspirante.getCorreo());
		AspiranteExistente.setNombre(aspirante.getNombre());
		AspiranteExistente.setApellido(aspirante.getApellido());
		AspiranteExistente.setTelefono(aspirante.getTelefono());
		AspiranteExistente.setDireccion(aspirante.getDireccion());
		AspiranteExistente.setNacionalidad(aspirante.getNacionalidad());
		AspiranteExistente.setContrato(aspirante.getContrato());

		servicio.actualizarAspirante(AspiranteExistente);
		return "redirect:/Administrador/Aspirante";
	}
		
	
}
