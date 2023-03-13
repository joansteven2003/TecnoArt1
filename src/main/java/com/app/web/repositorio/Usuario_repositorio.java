package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.web.modelos.Usuario;

@Repository
public interface Usuario_repositorio extends JpaRepository<Usuario, Long> {

}
