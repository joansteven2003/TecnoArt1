package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.modelos.Cargo;

public interface CargoRepositorio extends JpaRepository<Cargo,Long> {

}
