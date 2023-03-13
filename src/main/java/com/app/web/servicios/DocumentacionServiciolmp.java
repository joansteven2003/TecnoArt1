package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Documentacion;
import com.app.web.repositorio.DocumentacionRepositorio;

@Service
public class DocumentacionServiciolmp implements DocumentacionServicio {
	
	@Autowired
	private DocumentacionRepositorio repositorio;
	@Override
	public List<Documentacion> ListaTodaLaDocumentacion() {
		return repositorio.findAll();
	}

	@Override
	public Documentacion guardarDocumentacion(Documentacion documentacion) {
		return repositorio.save(documentacion);
	}

	@Override
	public Documentacion obtenerDocumentacionPorId(Long IdDocumentacion) {
		return repositorio.findById(IdDocumentacion).get();
	}

	@Override
	public Documentacion actualizarDocumenacion(Documentacion documentacion) {
		return repositorio.save(documentacion);
	}

	@Override
	public void eliminarDocumentacion(Long IdDocumentacion) {
		repositorio.deleteById(IdDocumentacion);	
		
	}

}
