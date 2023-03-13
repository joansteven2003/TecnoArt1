package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.modelos.Documentacion;

public interface DocumentacionRepositorio extends JpaRepository<Documentacion,Long> {

}
