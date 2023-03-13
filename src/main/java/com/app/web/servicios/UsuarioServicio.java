package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Usuario;

public interface UsuarioServicio {
	public List<Usuario> listarUsuarios();

	public Usuario guardarUsuarios(Usuario Usuario);

	public Usuario obtenerUsuariosPorId(long IdUsuario);

	public Usuario actualizarUsuarios(Usuario usuario);

	public void eliminarUsuarios(long IdUsuario);
}
