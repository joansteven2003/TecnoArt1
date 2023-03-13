package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.modelos.Aspirante;

@Repository
public interface AspiranteRepositorio extends JpaRepository<Aspirante,Long> {

}
