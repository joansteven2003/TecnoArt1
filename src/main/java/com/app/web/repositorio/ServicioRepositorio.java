package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.modelos.Servicio;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {

}
