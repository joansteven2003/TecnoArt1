package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.modelos.Vacante;

@Repository
public interface VacanteRepositorio extends JpaRepository<Vacante, Long> {

}
