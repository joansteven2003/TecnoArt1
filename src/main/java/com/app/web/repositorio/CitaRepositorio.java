package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.modelos.Cita;

public interface CitaRepositorio extends JpaRepository<Cita,Long> {

}
