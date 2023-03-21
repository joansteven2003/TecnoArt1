package com.app.web.controllers;

import com.app.web.modelos.*;
import com.app.web.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PqrsController {
	@Autowired
	private PqrsServicio servicio;
	@Autowired
 	private TipoServicio tipoServicio;
	@Autowired
	private PrioridadServicio prioridadServicio;
	@Autowired
	private EstadoServicio estadoServicio;

	@Autowired
	private VentaServicio ServicioVenta;


	@GetMapping("/Pqrs")
	public String listarPqrs(Model modelo) {
		modelo.addAttribute("Pqrs", servicio.listarPQRS());
		return "/Pqrs";
	}

	@GetMapping("/Cliente_Pqrs")
	public String listarPqrsCliente(Model modelo) {
		modelo.addAttribute("Pqrs", servicio.listarPQRS());
		return "/Cliente_Pqrs";
	}

	@GetMapping("/Pqrs/Registrar")
	public String MostrarRegistrarPqrsFormulario(Model modelo) {
		Pqrs pqrs = new Pqrs();
		List<Tipo> ListaTipo = tipoServicio.listarTipo();
		List<Prioridad> ListaPrio = prioridadServicio.listarPrioridad();
		List<Estado> ListaEstado = estadoServicio.listarEstado();
		List<Venta> listaVenta = ServicioVenta.listarVentas();

		modelo.addAttribute("Pqrs", pqrs);
		modelo.addAttribute("Tipos", ListaTipo);
		modelo.addAttribute("Prioridades", ListaPrio);
		modelo.addAttribute("Estados", ListaEstado);
		modelo.addAttribute("ventas", listaVenta);

		return "Generar_PQRS";
	}

	@PostMapping("/Pqrs/Guardar")
	public String guardarPqrs(@ModelAttribute("Pqrs") Pqrs pqrs) {
		servicio.guardarPqrs(pqrs);
		return "redirect:/Pqrs";
	}

	@GetMapping("/Pqrs/editar/{IdPqrs}")
	public String mostrarFormularioDeEitar(@PathVariable long IdPqrs, Model modelo) {
		modelo.addAttribute("pqrs", servicio.obtenerPqrsPorId(IdPqrs));
		return "/Editar_PQRS";
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
