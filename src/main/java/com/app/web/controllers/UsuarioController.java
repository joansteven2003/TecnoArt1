package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.modelos.Usuario;
import com.app.web.servicios.UsuarioServicio;

public class UsuarioController {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/Usuario")
	public String ListaUsuario(Model modelo) {
		modelo.addAttribute("Usuario", servicio.listarUsuarios());
		return "/Usuario";
	}
	
	@GetMapping("/Usuario/eliminar/{IdUsuario}")
	public String eliminarUsuario(@PathVariable long IdUsuario) {
		servicio.eliminarUsuarios(IdUsuario);
		return "redirect:/Usuario";
	}
		//experimentos//
		
	@GetMapping("/Usuario/Registrar")
	public String UsuarioFormulario(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("Usuario", usuario);
		return "/crearUsuario";
	}

	@PostMapping("/Guardar")
	public String guardarUsuario(@ModelAttribute("Usuario") Usuario usuario) {
		servicio.guardarUsuarios(usuario);
		return "redirect:/Usuario";

	}

	@GetMapping("/Usuario/editar/{IdUsuario}")
	public String EditarUsuarioFomulario(@PathVariable long IdUsuario, Model modelo) {
		modelo.addAttribute("Usuario", servicio.obtenerUsuariosPorId(IdUsuario));
		return "/editarUsuario";
	}

	@PostMapping("/Usuario/{IdUsuario}")
	public String EditarUsuario(@PathVariable long IdUsuario, @ModelAttribute("Usuario") Usuario usuario,
			Model modelo) {

		Usuario UsuarioExistente = servicio.obtenerUsuariosPorId(IdUsuario);
		UsuarioExistente.setIdUsuario(IdUsuario);
		UsuarioExistente.setNombre(usuario.getNombre());
		UsuarioExistente.setApellido(usuario.getApellido());
		UsuarioExistente.setDocumento(usuario.getDocumento());
		UsuarioExistente.setTelefono(usuario.getTelefono());
		UsuarioExistente.setCorreo(usuario.getCorreo());
		UsuarioExistente.setRecidencia(usuario.getRecidencia());
		UsuarioExistente.setPassword(usuario.getPassword());
		UsuarioExistente.setListVenta(usuario.getListVenta());
		UsuarioExistente.setRoles(usuario.getRoles());
		UsuarioExistente.setCargo(usuario.getCargo());
		
		

		servicio.actualizarUsuarios(UsuarioExistente);
		return "redirect:/Usuario";
	}
}
