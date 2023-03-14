package com.app.web.repositorio;

import com.app.web.modelos.Estado;
import com.app.web.modelos.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulacionRepositorio extends JpaRepository<Postulacion, Long> {
}
