package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.modelos.Documentacion;
import com.app.web.servicios.DocumentacionServicio;

@Controller
public class DocumentacionController {

	@Autowired
	private DocumentacionServicio servicio;
	
	@GetMapping("/Documentacion")
	public String ListaDocumentacion(Model modelo) {
		modelo.addAttribute("Documentacion", servicio.ListaTodaLaDocumentacion());
		return "/Documentacion";
	}
	
	@GetMapping("/Documentacion/eliminar/{IdDocumentacion}")
	public String eliminarDocumentacion(@PathVariable long IdDocumentacion) {
		servicio.eliminarDocumentacion(IdDocumentacion);
		return "redirect:/Documentacion";
	}
		//experimentos//
		
	@GetMapping("/Documentacion/Registrar")
	public String DocumentacionFormulario(Model modelo) {
		Documentacion documentacion = new Documentacion();
		modelo.addAttribute("Documentacion", documentacion);
		return "/crearDocumentacion";
	}

	@PostMapping("/Guardar")
	public String guardarDocumentacion(@ModelAttribute("Documentacion") Documentacion documentacion) {
		servicio.guardarDocumentacion(documentacion);
		return "redirect:/Documentacion";

	}

	@GetMapping("/Documentacion/editar/{IdDocumentacion}")
	public String EditarDocumentacionFomulario(@PathVariable long IdDocumentacion, Model modelo) {
		modelo.addAttribute("Documentacion", servicio.obtenerDocumentacionPorId(IdDocumentacion));
		return "/editarDocumentacion";
	}

	@PostMapping("/Documentacion/{IdDocumentacion}")
	public String EditarDocumentacion(@PathVariable long IdDocumentacion, @ModelAttribute("Documentacion") Documentacion documentacion,
			Model modelo) {

		Documentacion DocumentacionExistente = servicio.obtenerDocumentacionPorId(IdDocumentacion);
		DocumentacionExistente.setIdDucumentacion(IdDocumentacion);
		DocumentacionExistente.setCertificados(documentacion.getCertificados());
		DocumentacionExistente.setDocumenCentification(documentacion.getDocumenCentification());
		DocumentacionExistente.setHojaDeVida(documentacion.getHojaDeVida());
		servicio.actualizarDocumenacion(DocumentacionExistente);
		return "redirect:/Documentacion";
	}
}
