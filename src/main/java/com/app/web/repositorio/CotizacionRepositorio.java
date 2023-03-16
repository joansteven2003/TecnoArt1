package com.app.web.repositorio;

import com.app.web.modelos.Cotizacion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CotizacionRepositorio extends JpaRepository <Cotizacion,Long> {
}
