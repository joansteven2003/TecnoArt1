package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Usuario;
import com.app.web.repositorio.Usuario_repositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private Usuario_repositorio repositorio;

	@Override
	public List<Usuario> listarUsuarios() {
		return repositorio.findAll();
	}

	@Override
	public Usuario guardarUsuarios(Usuario usuario) {

		return repositorio.save(usuario);
	}

	@Override
	public Usuario obtenerUsuariosPorId(long IdUsuario) {
		return repositorio.findById(IdUsuario).get();
	}

	@Override
	public Usuario actualizarUsuarios(Usuario usuario) {
		return repositorio.save(usuario);
	}

	@Override
	public void eliminarUsuarios(long IdUsuario) {
		repositorio.deleteById(IdUsuario);

	}

}
