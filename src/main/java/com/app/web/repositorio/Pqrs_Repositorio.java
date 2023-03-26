package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.web.modelos.Pqrs;

import java.util.Optional;

@Repository
public interface Pqrs_Repositorio extends JpaRepository<Pqrs, Long> {
    Optional<Pqrs> findById(Long IdPqrs);
}
