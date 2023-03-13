package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.modelos.Tipo;

@Repository
public interface Tipo_repositorio extends JpaRepository<Tipo, Long> {

}
