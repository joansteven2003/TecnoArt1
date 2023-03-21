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

import com.app.web.modelos.Venta;
import com.app.web.servicios.VentaServicio;

import java.util.List;

@Controller
public class VentaController {
	@Autowired
	private VentaServicio servicio;

	@Autowired
	private UsuarioServicio usuarioServicio;

	@GetMapping("/Venta")
	public String listarVentas(Model modelo) {
		modelo.addAttribute("Venta", servicio.listarVentas());
		return "/Venta";
	}

	@GetMapping("/Venta/Registrar")
	public String mostrarFormularioRegistroVenta(Model modelo) {
		Venta venta = new Venta();
		List<Usuario> ListaUsuario= usuarioServicio.listarUsuarios();
		modelo.addAttribute("Venta", venta);
		modelo.addAttribute("Usuarios", ListaUsuario);
		return "/Generar_Venta";
	}

	@PostMapping("/Venta/Guardar")
	public String guardarVenta(@ModelAttribute("Venta") Venta venta) {
		servicio.guardarVenta(venta);
		return "redirect:/Venta";
	}

	@GetMapping("/Venta/editar/{IdVenta}")
	public String mostrarFormularioDeEditar(@PathVariable Long IdVenta, Model modelo) {
		modelo.addAttribute("Venta", servicio.obtenerVentaPorId(IdVenta));
		return "/Editar_Venta";
	}

	@PostMapping("/Venta/{IdVenta}")
	public String actualizarVentas(@PathVariable Long IdVenta, @ModelAttribute("Venta") Venta venta, Model modelo) {
		Venta ventaExistente = servicio.obtenerVentaPorId(IdVenta);
		ventaExistente.setIdVenta(IdVenta);
		ventaExistente.setFecha_venta(venta.getFecha_venta());
		ventaExistente.setFecha_entrega(venta.getFecha_entrega());
		ventaExistente.setMonto(venta.getMonto());
		ventaExistente.setEstado(venta.getEstado());
		ventaExistente.setObservacion(venta.getObservacion());
		ventaExistente.setUsuario(venta.getUsuario());
		
		servicio.actualizarVenta(ventaExistente);
		return "redirect:/Venta";

	}

	@GetMapping("/venta/{Id_venta}")
	public String eliminarVenta(@PathVariable Long Id_venta) {
		servicio.eliminarVenta(Id_venta);
		return "redirect:/venta";
	}
}
