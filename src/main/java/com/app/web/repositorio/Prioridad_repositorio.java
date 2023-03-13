package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.modelos.Prioridad;

@Repository
public interface Prioridad_repositorio extends JpaRepository<Prioridad, Long> {

}
