package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.modelos.Estado;

@Repository
public interface Estados_repositorio extends JpaRepository<Estado, Long> {

}
