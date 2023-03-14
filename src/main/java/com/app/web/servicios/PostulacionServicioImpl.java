package com.app.web.servicios;

import com.app.web.modelos.Postulacion;
import com.app.web.repositorio.PostulacionRepositorio;
import com.app.web.repositorio.Pqrs_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostulacionServicioImpl implements PostulacionServicio{

    @Autowired
    private PostulacionRepositorio repositorio;
    @Override
    public List<Postulacion> listarPostulacion() {
        return repositorio.findAll();
    }

    @Override
    public Postulacion guardarPostulacion(Postulacion postulacion) {
        return repositorio.save(postulacion);
    }

    @Override
    public Postulacion obtenerPostulacionPorId(long IdPostulacion) {
        return repositorio.findById(IdPostulacion).get();
    }

    @Override
    public Postulacion actualizarPostulacion(Postulacion postulacion) {
        return repositorio.save(postulacion);
    }

    @Override
    public void eliminarPostulacion(long IdPostulacion) {
        repositorio.deleteById(IdPostulacion);
    }
}
