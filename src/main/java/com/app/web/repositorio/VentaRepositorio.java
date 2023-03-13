package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.modelos.Venta;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Long> {

}
