package com.app.web.controllers;

import com.app.web.modelos.Usuario;
import com.app.web.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.app.web.modelos.HojaDeVida;

import com.app.web.servicios.HojaDeVidaServicio;

import java.util.List;

@Controller
public class HojaDeVidaController {
	@Autowired
	private HojaDeVidaServicio servicio;

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("/HojaDeVida")
	public String ListaHojaDeVida(Model modelo) {
		modelo.addAttribute("HojaDeVida", servicio.ListaTodosHojadevida());
		return "/HojaDeVida";
	}
	
	@GetMapping("/HojaDeVida/eliminar/{idaspirante}")
	public String eliminarHojaDeVida(@PathVariable long IdHojaDeVida) {
		servicio.eliminarHojadevida(IdHojaDeVida);
		return "redirect:/HojaDeVida";
	}
		//experimentos//
		
	@GetMapping("/HojaDeVida/Registrar")
	public String AspiranteHojaDeVida(Model modelo) {
		HojaDeVida hojaDeVida = new HojaDeVida();
		modelo.addAttribute("HojaDeVida", hojaDeVida);
		return "/Generar_HojaVida";
	}

	@PostMapping("/HojaDeVida/Guardar")
	public String guardarHojaDeVida(@ModelAttribute("HojaDeVida") HojaDeVida hojaDeVida) {
		servicio.guardarHojadevida(hojaDeVida);
		return "redirect:/HojaDeVida";

	}

	@GetMapping("/HojaDeVida/editar/{IdHojaDeVida}")
	public String EditarHojaDeVidaFomulario(@PathVariable long IdHojaDeVida, Model modelo) {
		modelo.addAttribute("HojaDeVida", servicio.obtenerHojadevidaPorId(IdHojaDeVida));
		return "/editarHojaDeVida";
	}

	@PostMapping("/HojaDeVida/{IdHojaDeVida}")
	public String EditarHojaDeVida(@PathVariable long IdHojaDeVida, @ModelAttribute("HojaDeVida") HojaDeVida hojaDeVida,
			Model modelo) {

		HojaDeVida HojaDeVidaExistente = servicio.obtenerHojadevidaPorId(IdHojaDeVida);
		HojaDeVidaExistente.setIdHojaDeVida(IdHojaDeVida);
		HojaDeVidaExistente.setInstitucion(hojaDeVida.getInstitucion());
		HojaDeVidaExistente.setTitulo(hojaDeVida.getTitulo());
		HojaDeVidaExistente.setFecha_grado(hojaDeVida.getFecha_grado());
		HojaDeVidaExistente.setEmpresa(hojaDeVida.getEmpresa());
		HojaDeVidaExistente.setPuesto(hojaDeVida.getPuesto());
		HojaDeVidaExistente.setFecha_inicio(hojaDeVida.getFecha_inicio());
		HojaDeVidaExistente.setFecha_fin(hojaDeVida.getFecha_fin());
		HojaDeVidaExistente.setDescripcionT(hojaDeVida.getDescripcionT());
		HojaDeVidaExistente.setHabilidades(hojaDeVida.getHabilidades());
		HojaDeVidaExistente.setReferencias(hojaDeVida.getReferencias());
		HojaDeVidaExistente.setUsuario(hojaDeVida.getUsuario());
		

		servicio.actualizarHojadevida(HojaDeVidaExistente);
		return "redirect:/HojaDeVidaExistente";
	}
}
