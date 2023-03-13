package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.modelos.Contrato;

@Repository
public interface ContratoRepositorio extends JpaRepository<Contrato,Long> {

}
