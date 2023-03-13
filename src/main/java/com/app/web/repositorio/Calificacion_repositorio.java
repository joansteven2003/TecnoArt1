package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.modelos.Calificacion;

@Repository
public interface Calificacion_repositorio extends JpaRepository<Calificacion, Long> {

}
