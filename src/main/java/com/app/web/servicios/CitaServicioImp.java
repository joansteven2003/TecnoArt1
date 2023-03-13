package com.app.web.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.modelos.Cita;
import com.app.web.repositorio.CitaRepositorio;

@Service
public class CitaServicioImp implements CitaServicio {
    
    @Autowired
    private CitaRepositorio repositorio;
    
    @Override
    public List<Cita> listarTodasLasCitas() {
        return repositorio.findAll();
    }
    
    @Override
    public Cita guardarCita(Cita cita) {
        return repositorio.save(cita);
    }
    
    @Override
    public Cita obtenerCitaPorId(Long idCita) {
        return repositorio.findById(idCita).get();
    }
    
    @Override
    public Cita actualizarCita(Cita cita) {
        return repositorio.save(cita);
    }
    
    @Override
    public void eliminarCita(Long idCita) {
        repositorio.deleteById(idCita);    
    }   
}

