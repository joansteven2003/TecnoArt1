package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.modelos.Resultado;

public interface ResultadoRepositorio extends JpaRepository<Resultado,Long> {

}
