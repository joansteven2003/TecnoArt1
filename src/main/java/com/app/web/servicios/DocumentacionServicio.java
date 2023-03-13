package com.app.web.servicios;

import java.util.List;

import com.app.web.modelos.Documentacion;

public interface DocumentacionServicio {

	public List<Documentacion> ListaTodaLaDocumentacion();
	
	public Documentacion guardarDocumentacion(Documentacion documentacion);
	
	public Documentacion obtenerDocumentacionPorId(Long IdDocumentacion);
	
	public Documentacion actualizarDocumenacion(Documentacion documentacion);
	
	public void eliminarDocumentacion(Long IdDocumentacion);
	
	
}
